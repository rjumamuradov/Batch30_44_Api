package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest05 {

    @Test
    public void GetRequest04() {
        String url = "http://dummy.restapiexample.com/";
        Response response = given()
                .accept("application/json")
                .when()
                .get(url);

        response.prettyPrint();


    }
}
