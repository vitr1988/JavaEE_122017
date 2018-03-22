package ru.otus.jaxws;

import javax.xml.ws.Endpoint;

public class EndpointPublisher {

   public static void main (String[] args) throws Exception {
        Endpoint.publish (
            "http://localhost:2304/JavaEE/soapcalculator",
                new SoapCalculator());
   }
}
