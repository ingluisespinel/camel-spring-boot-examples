package com.formadoresit.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ParallelProcessing extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:secondTimer?period=5s")
                .log("Init processing")
                .setBody(constant("Hola !"))
                .multicast().parallelProcessing()
                    .to("direct:routeA")
                    .to("direct:routeB")
                    .to("direct:routeC")
                .end();


        from("direct:routeA")
                .routeId("route-a")
                .log("Processing A with body ${body}")
                .process(exchange -> Thread.sleep(5000))
                .log("Ending A");

        from("direct:routeB")
                .routeId("route-b")
                .log("Processing B with body ${body}")
                .process(exchange -> Thread.sleep(5000))
                .log("Ending B");

        from("direct:routeC")
                .routeId("route-c")
                .log("Processing C with body ${body}")
                .process(exchange -> Thread.sleep(5000))
                .log("Ending C");
    }
}
