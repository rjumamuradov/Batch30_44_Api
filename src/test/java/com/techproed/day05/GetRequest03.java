package com.techproed.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest03 {
    @Test
    public void testGetRequest03(){

        String url="https://restful-booker.herokuapp.com/booking/7";
        Response response= given()
                .accept("application/json")
                .when()
                .get(url);

        response.prettyPrint();
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Eric"))
                .body("lastname", equalTo("Jones"))
                .body("totalprice", equalTo("<165>"))
                .body("depositpaid", equalTo("false"));

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Jim"),
                        "latname",equalTo("Jones"),
                        "totalprice",equalTo("421"),
                        "checkout",equalTo("2021-09-02"));

    }
}
