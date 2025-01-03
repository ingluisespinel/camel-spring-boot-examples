package com.lespinel.camel.soap.producer;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.1
 * 2024-11-08T18:10:04.885-05:00
 * Generated source version: 4.0.1
 *
 */
@WebService(targetNamespace = "http://producer.soap.camel.lespinel.com/", name = "OrdersService")
@XmlSeeAlso({ObjectFactory.class})
public interface OrdersService {

    @WebMethod
    @RequestWrapper(localName = "createOrder", targetNamespace = "http://producer.soap.camel.lespinel.com/", className = "com.lespinel.camel.soap.producer.CreateOrder")
    @ResponseWrapper(localName = "createOrderResponse", targetNamespace = "http://producer.soap.camel.lespinel.com/", className = "com.lespinel.camel.soap.producer.CreateOrderResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String createOrder(

        @WebParam(name = "arg0", targetNamespace = "")
        com.lespinel.camel.soap.producer.OrderRequest arg0
    );

    @WebMethod
    @RequestWrapper(localName = "queryOrder", targetNamespace = "http://producer.soap.camel.lespinel.com/", className = "com.lespinel.camel.soap.producer.QueryOrder")
    @ResponseWrapper(localName = "queryOrderResponse", targetNamespace = "http://producer.soap.camel.lespinel.com/", className = "com.lespinel.camel.soap.producer.QueryOrderResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.lespinel.camel.soap.producer.OrderResponse queryOrder(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
