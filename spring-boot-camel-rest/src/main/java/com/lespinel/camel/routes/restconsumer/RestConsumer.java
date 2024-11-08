package com.lespinel.camel.routes.restconsumer;

import com.lespinel.camel.domain.Order;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class RestConsumer extends RouteBuilder {
    private JsonDataFormat jsonDataFormat;

    public RestConsumer(){
        jsonDataFormat = new JsonDataFormat();
        jsonDataFormat.setUnmarshalType(Order.class);
        jsonDataFormat.useList(true);
    }

    @Override
    public void configure() throws Exception {
        rest("/process/objects")
                .description("Endpoint to exemplify the API REST consumption")
                .get()
                .to("direct:handleProcessRequest")
                .post()
                .to("direct:createNewObject");

        from("direct:handleProcessRequest")
                .routeId("handle-process-request")
                .to("direct:consumeExternalApi");

        from("direct:consumeExternalApi")
                .log("Calling external API")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("http://localhost:3000/api/v1/orders?bridgeEndpoint=true")
                .unmarshal().json(Order[].class)
                .split(body())
                    .log("Body class ${body.class}, Content ${body}")
                .end();

        from("direct:callCreateNewObject")
                .log("Creating new object over External API")
                .setHeader(Exchange.HTTP_METHOD, constant("POST"))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .to("http://api.restful-api.dev/objects?bridgeEndpoint=true");
    }
}