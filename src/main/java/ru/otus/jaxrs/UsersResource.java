package ru.otus.jaxrs;

import ru.otus.jaxrs.model.User;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/user")
public class UsersResource {

    @Context
    UriInfo info;

    @Context
    Request request;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public User createUser(/*@NotBlank(message="{user.name.notnull}") @FormParam("username") String username,
                           @NotBlank(message="{user.firstname.notnull}") @FormParam("firstname") String firstname,
                           @NotBlank(message="{user.lastname.notnull}") @FormParam("lastname") String lastname,
                           @NotBlank(message="{user.email}") @Email @FormParam("email") String email*/
               @Valid @BeanParam User user) {
        return user;//new User(username, firstname, lastname, email);
    }
}
