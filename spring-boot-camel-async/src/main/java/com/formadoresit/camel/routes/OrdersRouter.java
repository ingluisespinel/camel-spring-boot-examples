package com.formadoresit.camel.routes;

import com.formadoresit.camel.services.OrdersService;
import org.apache.camel.ExchangePattern;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrdersRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:mainTimer?period={{timer.period}}")
                .routeId("mainTimer")
                .log("mainTimer started")
                .setBody(simple("${random(100)}"))
                .to("seda:processOrderAsync")
                .log("mainTimer finished");

        /*
            Componente seda
                habilita el procesamiento de exchange de manera asíncrona
         */
        from("seda:processOrderAsync?concurrentConsumers=10")
                .routeId("process-order-async")
                .bean(OrdersService.class, "processOrder")
                .to("seda:sendOrderToQueue");

        /*
         * Componente direct
         * Por default el comportamiento es síncrono - bloqueante
         */
        from("direct:processOrderSync")
                .routeId("process-order-sync")
                .bean(OrdersService.class, "processOrder");

        from("seda:sendOrderToQueue?concurrentConsumers=10")
                .routeId("orders-producer")
                .log("Sending order ${body} to queue")
                .to("activemq:queue:ordersToProcess");

        from("activemq:queue:ordersToProcess")
                .routeId("orders-consumer")
                .log("Processing new event from queue. Order Id '${body.id}'");
    }

}