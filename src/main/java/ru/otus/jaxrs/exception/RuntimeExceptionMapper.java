package ru.otus.jaxrs.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof ArithmeticException) {

        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(exception.getLocalizedMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
