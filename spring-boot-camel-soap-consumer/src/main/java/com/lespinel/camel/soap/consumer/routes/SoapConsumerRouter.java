package com.lespinel.camel.soap.consumer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class SoapConsumerRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:mainTimer?period={{app.soap.consumer.period}}")
                .routeId("mainTimer")
                .bean("orderGenerator", "createOrder")
                .setHeader(CxfConstants.OPERATION_NAME, constant("createOrder"))
                .to("cxf://http://127.0.0.1:8080/services/ws/soap?serviceClass=com.lespinel.camel.soap.producer.OrdersService&wsdlURL=myService.wsdl")
                .log("Body Response: ${body}");
    }

}
