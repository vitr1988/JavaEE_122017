package ru.otus.testing;

import org.eclipse.jetty.http.HttpTester;
import org.eclipse.jetty.servlet.ServletTester;
import org.junit.Ignore;
import org.junit.Test;
import ru.otus.mail.servlet.MailServlet;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class HelloWorldServletTest {
    @Test
    public void shouldTestTextPrinted() {
        try {
            ServletTester servletTester = new ServletTester();
            servletTester.addServlet(HelloWorldServlet.class, "/testing");
            servletTester.start();

            HttpTester.Request request = HttpTester.newRequest();
            request.setMethod("GET");
            request.setURI("/testing");
            request.setVersion("HTTP/1.0");
            HttpTester.Response response = HttpTester.parseResponse(servletTester.getResponses(request.generate()));

            assertEquals(200, response.getStatus());
            assertEquals("Hello World", response.getContent());
        }
        catch (Exception e) {
            fail();
        }
    }

    @Ignore
    @Test
    public void shouldTestHelloWorldTextPrinted() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target =
                client.target("http://localhost:8080/JavaEE/testing");

        Response response = target.request(MediaType.TEXT_HTML).get();
        assertEquals(200, response.getStatus());
    }
}
