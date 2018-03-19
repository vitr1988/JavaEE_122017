package ru.otus.jaxrs.model;

import io.swagger.annotations.ApiParam;

import javax.ws.rs.FormParam;

public class User {

    @ApiParam(value = "username", required = true)
    @FormParam("username")
    private String username;

    @ApiParam(value = "firstname", required = true)
    @FormParam("firstname")
    private String firstname;

    @ApiParam(value = "lastname", required = true)
    @FormParam("lastname")
    private String lastname;

    @ApiParam(value = "email", required = true)
    @FormParam("email")
    private String email;

    public User() {
    }

    public User(String username, String firstname, String lastname, String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
