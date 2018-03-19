package ru.otus.jaxrs.async;

import com.sun.jersey.core.header.OutBoundHeaders;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Providers;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseEventSink;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("reports")
public class ReportResource {

    @Context
    Application app; // provides access to application configuration information.
    @Context
    UriInfo uri; // provides access to application and request URI information.
    @Context
    HttpHeaders headers; // provides access to HTTP header information either as a Map or as convenience methods.
                         // Note that @HeaderParam can also be used to bind an HTTP header to a resource method parameter,
                         // field, or bean property.
    @Context
    Request request; // provides a helper to request processing and is typically used with Response to dynamically build the response.
    @Context
    SecurityContext security; // provides access to security-related information about the current request.
    @Context
    Providers providers; // supplies information about runtime lookup of provider instances based on a set of search criteria.

    @Resource
    private ManagedScheduledExecutorService executor;

    @GET
    @Path("/{id}")
    public void getReportDescription(@PathParam("id") String id,
                                             @Suspended AsyncResponse async) {
        async.setTimeout(2000, TimeUnit.MILLISECONDS);
        async.setTimeoutHandler(new CancelTimeoutHandlerImpl());
        // Optionally, send request to executor queue for processing
        // ...
        executor.execute(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Retrieve the book data for 'id'
                // which is presumed to be a very slow, blocking operation
                // ...
                List<String> reportData = new ArrayList<>();
                // Re-activate the client connection with 'resume'
                // and send the 'bookdata' object as the response
                async.resume(reportData);
            }
        });
    }

    @GET
    @Path("/all")
    public void getAll(@Suspended final AsyncResponse ar) {
        ar.register(new CompletionCallbackImpl());
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void reportComplete(
            @Context SseEventSink eventSink,
            @Context Sse sse) {
        try (SseEventSink sink = eventSink) {
            sink.send(sse.newEvent("Report is Generating"));
            sink.send(sse.newEvent("Report is still Generating", "Some data"));
            OutboundSseEvent event = sse.newEventBuilder().
                    id("ReportId").
                    name("Account Report").
                    data("Big Report Data").
                    reconnectDelay(1000).
                    comment("Your ads could be here").build();
            sink.send(event);
        }
    }

    private class CompletionCallbackImpl implements CompletionCallback {
        @Override
        public void onComplete(Throwable t) {
            //. . .
        }
    }

    private class CancelTimeoutHandlerImpl implements TimeoutHandler {

        @Override
        public void handleTimeout(AsyncResponse asyncResponse) {
            asyncResponse.cancel();
        }

    }
}
