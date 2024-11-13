package com.lespinel.camel.metrics.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExampleRouter extends RouteBuilder {
    @Value("${app.camel.logs.extended:false}")
    private Boolean extendedLogs;

    @Override
    public void configure() {
        getContext().setTracing(extendedLogs);

        interceptFrom("direct:processBody")
                .log("new message intercepted")
                .to("micrometer:counter:my.counter?increment=1");

        from("timer:hello?period={{timer.period}}")
                .routeId("main-timer")
                .setBody(constant("My Body String"))
                .to("direct:processBody")
                .log("finish..");

        from("direct:processBody")
                .routeId("body-processor")
                .log("processing message ${headers}")
                .setBody(simple("${body.length}"))
                .log("Processed body ${body}");

    }

}