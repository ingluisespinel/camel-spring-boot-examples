package com.lespinel.camel.domain;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();

    Order getById(long id);

    void add(Order order);

}
