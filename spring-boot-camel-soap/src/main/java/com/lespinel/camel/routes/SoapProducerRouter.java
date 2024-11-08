package com.lespinel.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class SoapProducerRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("cxf:bean:cxfEndpoint")
                .log("Processing new request.")
                        .choice()
                                .when(simple("${properties:app.processingMode} == 'dynamic'"))
                                    .to("direct:processOperationDynamically")
                                .when(simple("${properties:app.processingMode} == 'choice'"))
                                    .to("direct:processOperationWithChoice")
                                .otherwise()
                                    .log("ProcessingMode not supported")
                        .endChoice();

        from("direct:processOperationDynamically")
                .log("Processing dynamically")
                .setHeader(Exchange.BEAN_METHOD_NAME, simple("${headers.operationName}"))
                .bean("ordersServiceImp");;

        from("direct:processOperationWithChoice")
                .log("Processing from choice EIP")
                .choice()
                    .when(header("operationName").isEqualTo("createOrder"))
                        .bean("ordersServiceImp", "createOrder")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("queryOrder"))
                        .bean("ordersServiceImp", "queryOrder")
                .endChoice();
    }

}
