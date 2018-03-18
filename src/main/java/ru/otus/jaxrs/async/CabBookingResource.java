package ru.otus.jaxrs.async;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Path("cabs")
public class CabBookingResource {

    @Resource
    ManagedExecutorService executorService;

    @GET
    @Path("{id}")
    public CompletionStage<String> getCab(@PathParam("id") final String name) {
        System.out.println("HTTP request handled by thread " + Thread.currentThread().getName());
        final CompletableFuture<Boolean> validateUserTask = new CompletableFuture<>();
        CompletableFuture<String> searchDriverTask = validateUserTask.thenComposeAsync(
                (valid) -> {
                    System.out.println("User validated ? " + valid);
                    return CompletableFuture.supplyAsync(() -> searchDriver(), executorService);
                }, executorService); // we orchestrate the tasks for user validation and driver search
        final CompletableFuture<String> notifyUserTask = searchDriverTask.thenApplyAsync(
                (driver) -> notifyUser(driver), executorService);
        executorService.execute(() -> {
            validateUserTask.complete(validateUser(name));
        });

        return notifyUserTask;
    }

    private boolean validateUser(String id) {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());
        System.out.println("validating user " + id);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    private String searchDriver() {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "besttaxidriver";
    }

    private String notifyUser(String info) {
        System.out.println("searchDriverTask handled by thread " + Thread.currentThread().getName());
        return "Your driver is " + info + " and the OTP is " + (new Random().nextInt(999) + 1000);
    }


}
