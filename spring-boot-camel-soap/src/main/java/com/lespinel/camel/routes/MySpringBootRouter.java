package com.lespinel.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("cxf:bean:cxfEndpoint")
                .log("Processing new request.")
                .setHeader(Exchange.BEAN_METHOD_NAME, simple("${headers.operationName}"))
                .bean("ordersServiceImp");
                /*
                .choice()
                    .when(header("operationName").isEqualTo("createOrder"))
                        .bean("ordersServiceImp", "createOrder")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("queryOrder"))
                        .bean("ordersServiceImp", "queryOrder")
                .endChoice();
                 */
    }

}
