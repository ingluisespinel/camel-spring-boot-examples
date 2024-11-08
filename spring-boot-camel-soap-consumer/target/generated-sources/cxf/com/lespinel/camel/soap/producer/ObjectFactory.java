
package com.lespinel.camel.soap.producer;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.lespinel.camel.soap.producer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateOrder_QNAME = new QName("http://producer.soap.camel.lespinel.com/", "createOrder");
    private final static QName _CreateOrderResponse_QNAME = new QName("http://producer.soap.camel.lespinel.com/", "createOrderResponse");
    private final static QName _OrderResponse_QNAME = new QName("http://producer.soap.camel.lespinel.com/", "orderResponse");
    private final static QName _QueryOrder_QNAME = new QName("http://producer.soap.camel.lespinel.com/", "queryOrder");
    private final static QName _QueryOrderResponse_QNAME = new QName("http://producer.soap.camel.lespinel.com/", "queryOrderResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.lespinel.camel.soap.producer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateOrder }
     * 
     */
    public CreateOrder createCreateOrder() {
        return new CreateOrder();
    }

    /**
     * Create an instance of {@link CreateOrderResponse }
     * 
     */
    public CreateOrderResponse createCreateOrderResponse() {
        return new CreateOrderResponse();
    }

    /**
     * Create an instance of {@link OrderResponse }
     * 
     */
    public OrderResponse createOrderResponse() {
        return new OrderResponse();
    }

    /**
     * Create an instance of {@link QueryOrder }
     * 
     */
    public QueryOrder createQueryOrder() {
        return new QueryOrder();
    }

    /**
     * Create an instance of {@link QueryOrderResponse }
     * 
     */
    public QueryOrderResponse createQueryOrderResponse() {
        return new QueryOrderResponse();
    }

    /**
     * Create an instance of {@link OrderRequest }
     * 
     */
    public OrderRequest createOrderRequest() {
        return new OrderRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://producer.soap.camel.lespinel.com/", name = "createOrder")
    public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value) {
        return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://producer.soap.camel.lespinel.com/", name = "createOrderResponse")
    public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value) {
        return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://producer.soap.camel.lespinel.com/", name = "orderResponse")
    public JAXBElement<OrderResponse> createOrderResponse(OrderResponse value) {
        return new JAXBElement<OrderResponse>(_OrderResponse_QNAME, OrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://producer.soap.camel.lespinel.com/", name = "queryOrder")
    public JAXBElement<QueryOrder> createQueryOrder(QueryOrder value) {
        return new JAXBElement<QueryOrder>(_QueryOrder_QNAME, QueryOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QueryOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://producer.soap.camel.lespinel.com/", name = "queryOrderResponse")
    public JAXBElement<QueryOrderResponse> createQueryOrderResponse(QueryOrderResponse value) {
        return new JAXBElement<QueryOrderResponse>(_QueryOrderResponse_QNAME, QueryOrderResponse.class, null, value);
    }

}
