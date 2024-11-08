package com.lespinel.camel.soap.consumer.service;

import com.lespinel.camel.soap.producer.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderGenerator {

    public OrderRequest createOrder(){
        var orderRequest = new OrderRequest();
        orderRequest.setId("A1");
        orderRequest.setOwner("John Doe");
        orderRequest.setTotal(1000);
        return orderRequest;
    }
}
