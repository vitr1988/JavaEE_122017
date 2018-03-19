package ru.otus.jaxrs;

import io.swagger.annotations.*;
import ru.otus.jaxrs.model.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/user")
@SwaggerDefinition(
    info = @Info(
        title = "User Resource Swagger-generated API",
        description = "User Resource Description example",
        version = "1.0.0",
        termsOfService = "share and care",
        contact = @Contact(
            name = "Vitalii", email = "v_ivanov@otus.ru",
            url = "https://otus.ru"),
        license = @License(
            name = "Apache 2.0",
            url = "http://www.apache.org")),
    tags = {
        @Tag(name = "User Resource Swagger-generated API",
            description = "Description Example")
    },
    host = "localhost:8080",
    basePath = "/JavaEE/api",
    schemes = {SwaggerDefinition.Scheme.HTTP},
    externalDocs = @ExternalDocs(
        value = "Developing a Swagger-enabled REST API using WebSphere Developer Tools",
        url = "https://tinyurl.com/swagger-wlp"))
@Api(tags = "User Resource Swagger-generated API", produces = MediaType.APPLICATION_JSON)
public class UsersResource {

    @Context
    UriInfo info;

    @Context
    Request request;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiOperation(value = "Create an user",
        notes = "Create user by HTML form",
        produces = MediaType.APPLICATION_JSON)
    @ApiResponses({
        @ApiResponse(code = 200, message = "A valid user")
    })
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "User's name", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "firstname", value = "First name", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "lastname", value = "Last name", dataType = "string", paramType = "form"),
        @ApiImplicitParam(name = "email", value = "User's email", dataType = "string", paramType = "form")
    })
    public User createUser(/*@NotBlank(message="{user.name.notnull}") @FormParam("username") String username,
                           @NotBlank(message="{user.firstname.notnull}") @FormParam("firstname") String firstname,
                           @NotBlank(message="{user.lastname.notnull}") @FormParam("lastname") String lastname,
                           @NotBlank(message="{user.email}") @Email @FormParam("email") String email*/
               @Valid @BeanParam User user) {
        return user;//new User(username, firstname, lastname, email);
    }
}
