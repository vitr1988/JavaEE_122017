
package ru.otus.jaxws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DateWebService", targetNamespace = "http://jaxws.otus.ru/", wsdlLocation = "http://localhost:8080/JavaEE/DateWebService?wsdl")
public class DateWebService
    extends Service
{

    private final static URL DATEWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException DATEWEBSERVICE_EXCEPTION;
    private final static QName DATEWEBSERVICE_QNAME = new QName("http://jaxws.otus.ru/", "DateWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/JavaEE/DateWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DATEWEBSERVICE_WSDL_LOCATION = url;
        DATEWEBSERVICE_EXCEPTION = e;
    }

    public DateWebService() {
        super(__getWsdlLocation(), DATEWEBSERVICE_QNAME);
    }

    public DateWebService(WebServiceFeature... features) {
        super(__getWsdlLocation(), DATEWEBSERVICE_QNAME, features);
    }

    public DateWebService(URL wsdlLocation) {
        super(wsdlLocation, DATEWEBSERVICE_QNAME);
    }

    public DateWebService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DATEWEBSERVICE_QNAME, features);
    }

    public DateWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DateWebService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DateProvider
     */
    @WebEndpoint(name = "DateProviderPort")
    public DateProvider getDateProviderPort() {
        return super.getPort(new QName("http://jaxws.otus.ru/", "DateProviderPort"), DateProvider.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DateProvider
     */
    @WebEndpoint(name = "DateProviderPort")
    public DateProvider getDateProviderPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://jaxws.otus.ru/", "DateProviderPort"), DateProvider.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DATEWEBSERVICE_EXCEPTION!= null) {
            throw DATEWEBSERVICE_EXCEPTION;
        }
        return DATEWEBSERVICE_WSDL_LOCATION;
    }

}
