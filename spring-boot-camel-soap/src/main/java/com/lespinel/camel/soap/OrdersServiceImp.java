package com.lespinel.camel.soap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrdersServiceImp implements OrdersService{

    @Override
    public String createOrder(OrderRequest orderRequest) {
        log.info("Processing new Order {}", orderRequest);
        return "CREATED";
    }

    @Override
    public OrderResponse queryOrder(String id) {
        log.info("Query Order by id {}", id);
        return OrderResponse.builder()
                .id(id)
                .build();
    }
}
