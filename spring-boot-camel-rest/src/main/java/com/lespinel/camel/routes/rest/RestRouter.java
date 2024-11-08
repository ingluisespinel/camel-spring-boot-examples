package com.lespinel.camel.routes.rest;

import com.lespinel.camel.domain.Order;
import com.lespinel.camel.processors.InputDataErrorProcessor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RestRouter extends RouteBuilder {

    @Override
    public void configure() {
        // Configurar la ruta REST usando Undertow
        restConfiguration()
                .component("servlet")  // https://camel.apache.org/manual/rest-dsl.html
                .host("0.0.0.0").port(8080)
                .bindingMode(RestBindingMode.json)
                .dataFormatProperty("json.in.disableFeatures", "FAIL_ON_UNKNOWN_PROPERTIES")
                .contextPath("/api/camel")  // Prefijo del contexto REST
                .apiContextPath("/api-docs")  // Documentación de la API REST (opcional)
                .enableCORS(true)
                .apiProperty("api.title", "Orders API")  // Información de la API
                .apiProperty("api.version", "1.0.0");

        rest("/orders")
                .description("CRUD Orders Services")
                .consumes("application/json")
                .produces("application/json")
                .get()
                    .outType(Order[].class)
                    .to("direct:getAllOrders")
                .get("/{id}")
                    .outType(Order.class)
                    .to("direct:getOrderById")
                .post()
                    .type(Order.class)
                    .outType(Order.class)
                    .to("direct:createNewOrder");

        from("direct:getAllOrders")
                .routeId("process-get-all-orders")
                .bean("fakeOrderRepoImp", "getAll")
                .log("Body: ${body}");

        from("direct:getOrderById")
                .routeId("process-get-order-by-id")
                .log("Processing new request with headers ${headers}")
                .bean("fakeOrderRepoImp", "getById(${headers.id})")
                .choice()
                    .when(simple("${body} == null"))
                        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(404))
                .end();

        from("direct:createNewOrder")
                .routeId("process-new-order")
                .doTry()
                    .log("Creating new Order")
                    .to("bean-validator:validateOrder")
                    .bean("fakeOrderRepoImp", "add(${body})")
                    .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
                .doCatch(ValidationException.class)
                    .process(new InputDataErrorProcessor())
                .end()
                .log("Request finished");
    }

}
