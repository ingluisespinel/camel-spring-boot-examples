package com.lespinel.camel.config;

import com.lespinel.camel.soap.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.component.cxf.common.DataFormat;
import org.apache.camel.component.cxf.jaxws.CxfEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CxfConfig {

    @Bean
    public CxfEndpoint cxfEndpoint() {
        log.info("Creating CxfEndpoint Bean");
        final CxfEndpoint result = new CxfEndpoint();
        result.setServiceClass(OrdersService.class);
        result.setDataFormat(DataFormat.POJO);
        result.setMtomEnabled(true);
        result.setAddress("/ws/soap");
        return result;
    }

}
