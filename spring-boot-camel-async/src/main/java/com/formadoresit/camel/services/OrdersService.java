package com.formadoresit.camel.services;

import com.formadoresit.camel.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrdersService {

    public Order processOrder(String id) throws InterruptedException {
        log.info("Processing Order {}", id);
        Thread.sleep(10000);
        log.info("Order Processed {}", id);
        return Order.builder()
                .id("Order-"+id)
                .total(1000)
                .owner("Apache Camel")
                .build();
    }

}
