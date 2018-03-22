package ru.otus.jaxws.handler;

import org.w3c.dom.Node;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

public class SoapCalculatorHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext mc) {
        System.out.println("Server : handleMessage()......");

        return true;
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return Collections.emptySet();
    }

    @Override
    public void close(MessageContext mc) {
        System.out.println("Server : close()......");
    }

    @Override
    public boolean handleFault(SOAPMessageContext mc) {
        System.out.println("Server : handleFault()......");
        return true;
    }
}

