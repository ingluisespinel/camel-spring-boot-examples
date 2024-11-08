package com.lespinel.camel.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface OrdersService {

    @WebMethod
    String createOrder(OrderRequest orderRequest);

    @WebMethod
    OrderResponse queryOrder(String id);

}
