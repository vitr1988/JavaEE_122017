package ru.otus.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/calculator")
public class RestfulCalculator implements Calculatable {

    @GET
    @Path("/sqrt/{value}")
    @Produces(MediaType.TEXT_HTML)
    public Response calcSqrt(@PathParam("value") int value) {
        double answer = Math.sqrt(value);
        String msg = String.format("calcSqrt==> value: %d, answer: %10.4f", value, answer);
        return Response.status(200).entity(msg).build();
    }

    @GET
    @Path("/plus/{value1}/{value2}")
    @Produces(MediaType.TEXT_HTML)
    public Response calcAddTwoValues(@PathParam("value1") double value1,
                                     @PathParam("value2") double value2) {
        double answer = value1 + value2;
        String msg =
                String.format("calcAddTwoValues==> value1: %10.4f, value2: %10.4f, answer: %10.4f", value1, value2, answer);
        return Response.status(200).entity(msg).build();
    }

    @GET
    @Path("/minus/{value1}/{value2}")
    @Produces(MediaType.TEXT_HTML)
    public Response calcSubTwoValues(@PathParam("value1") double value1,
                                     @PathParam("value2") double value2) {
        double answer = value1 - value2;
        String msg = String.format("calcSubTwoValues==> value1: %10.4f, value2: %10.4f, answer: %10.4f",
                value1, value2, answer);
        return Response.status(200).entity(msg).build();
    }

    @GET
    @Path("/div/{value1}/{value2}")
    @Produces(MediaType.TEXT_HTML)
    public Response calcDivTwoValues(@PathParam("value1") double value1,
                                     @PathParam("value2") double value2) {
        if (value2 == 0) {
            throw new WebApplicationException("Div by 0 is prohibited");
        }
        int answer = (int) value1 / (int) value2;
        String msg = String.format("calcDivTwoValues==> value1: %10.4f, value2: %10.4f, answer: %10.4f",
                value1, value2, answer);
        return Response.status(200).entity(msg).build();
    }
}
