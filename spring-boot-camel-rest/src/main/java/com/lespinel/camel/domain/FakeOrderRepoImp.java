package com.lespinel.camel.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class FakeOrderRepoImp implements OrderRepository {
    private final List<Order> orders;

    public FakeOrderRepoImp(){
        orders = new ArrayList<>();
        // Dummy data for tests
        var order = Order.builder()
                .id(1)
                .owner("Carlos")
                .items(List.of(Item.builder()
                                .name("Product One")
                                .amount(1000)
                        .build()))
                .build();
        orders.add(order);
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order getById(long id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void add(Order newOrder) {
        log.info("Adding new Order");
        this.orders.add(newOrder);
    }
}
