package ru.otus.testing;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class RestAssuredTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void whenRequestGet_thenOK(){
//        given().log().all(). - log request for debugging
        when().request("GET", "/JavaEE/api/calculator/sqrt/25").then()
//        .log().body() - log response for debugging
        .statusCode(200);
    }

    @Test
    public void whenValidateResponseTime_thenSuccess() {
        when().get("/JavaEE/api/calculator/sqrt/25").then().time(lessThan(5L), TimeUnit.SECONDS);
    }
}
