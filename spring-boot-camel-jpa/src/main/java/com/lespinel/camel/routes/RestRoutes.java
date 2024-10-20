package com.lespinel.camel.routes;

import com.lespinel.camel.domain.User;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // Configurar la ruta REST usando Undertow
        restConfiguration()
                .component("undertow")  // https://camel.apache.org/manual/rest-dsl.html
                .host("localhost").port(8080)
                .bindingMode(RestBindingMode.json)
                .contextPath("/api/camel")  // Prefijo del contexto REST
                .apiContextPath("/api-docs")  // Documentación de la API REST (opcional)
                .enableCORS(true)
                .apiProperty("api.title", "Users API")  // Información de la API
                .apiProperty("api.version", "1.0.0");

        // Definir el servicio REST para GET /api/users
        rest("/users")
                .get()
                    .to("direct:getUsersDirectlyByJPA")
                .get("/by-name")
                    .to("direct:queryUsersByNameWithJpa")
                .post()
                    // Usamos directamente el Entity como clase esperada
                    // Solo con fines demostrativos. Deberíamos esperar un DTO
                    .type(User.class)
                    .to("direct:processUserCreationRequests");


        from("direct:processUserCreationRequests")
                .routeId("process-user-creation")
                .transacted() // Habilitar el manejo transaccional dentro del flujo
                .log("processing creation user request")
                .to("direct:insertUser")
                .to("direct:notifyNewUser")
                .setHeader(Exchange.HTTP_RESPONSE_CODE,  constant(201))
                .end();
    }
}
