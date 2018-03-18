package ru.otus.jaxrs.client;

import ru.otus.xml.Customer;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;

public class RestClient {

    public static void main(String[] args) throws Exception {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        clientBuilder.register(ClientLoggingFilter.class);
        Client client = clientBuilder.build();
        WebTarget target =
                client.target("http://localhost:8080/JavaEE/api/calculator/sqrt")
                .path("{value}")
                .resolveTemplate("value", 144);

        Response response = target.request(MediaType.TEXT_HTML)
//                .post(Entity.entity(new User(), "application/json");
                .header("myHeader", "The header value")
                .cookie("myCookie", "The cookie value")
                .get();
        Future<String> result = target.request().async().get(new InvocationCallback<String>() {
            @Override
            public void completed(String customer) {
                // Do something with the customer object
            }
            @Override
            public void failed(Throwable throwable) {
                // handle the error
            }
        });

        CompletionStage<String> csf = target.request().rx().get(String.class);
        csf.thenAccept(System.out::println);

        Invocation i1 = target.request().buildGet();
        System.out.println(response.readEntity(String.class));
        System.out.println(result.get());
        System.out.println(i1.invoke(String.class));
    }
}
