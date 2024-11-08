package com.lespinel.camel.soap.producer;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.1
 * 2024-11-08T18:10:04.929-05:00
 * Generated source version: 4.0.1
 *
 */
@WebServiceClient(name = "OrdersServiceService",
                  wsdlLocation = "file:/home/luis/Development/Apache%20Camel/FormadoresIT/camel-spring-boot-examples/spring-boot-camel-soap-consumer/src/main/resources/myService.wsdl",
                  targetNamespace = "http://producer.soap.camel.lespinel.com/")
public class OrdersServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://producer.soap.camel.lespinel.com/", "OrdersServiceService");
    public final static QName OrdersServicePort = new QName("http://producer.soap.camel.lespinel.com/", "OrdersServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/home/luis/Development/Apache%20Camel/FormadoresIT/camel-spring-boot-examples/spring-boot-camel-soap-consumer/src/main/resources/myService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(OrdersServiceService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/home/luis/Development/Apache%20Camel/FormadoresIT/camel-spring-boot-examples/spring-boot-camel-soap-consumer/src/main/resources/myService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public OrdersServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public OrdersServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OrdersServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public OrdersServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public OrdersServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public OrdersServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns OrdersService
     */
    @WebEndpoint(name = "OrdersServicePort")
    public OrdersService getOrdersServicePort() {
        return super.getPort(OrdersServicePort, OrdersService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrdersService
     */
    @WebEndpoint(name = "OrdersServicePort")
    public OrdersService getOrdersServicePort(WebServiceFeature... features) {
        return super.getPort(OrdersServicePort, OrdersService.class, features);
    }

}
