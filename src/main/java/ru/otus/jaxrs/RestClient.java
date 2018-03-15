package ru.otus.jaxrs;

import ru.otus.jaxrs.model.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {

    public static void main(String[] args) throws Exception {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target =
                client.target("http://localhost:8080/JavaEE/api/calculator/sqrt/144");
        Response response = target.request().get();
        System.out.println(response.readEntity(String.class));
    }
}
