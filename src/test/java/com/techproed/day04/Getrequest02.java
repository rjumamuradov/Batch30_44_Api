package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Getrequest02 {
    @Test
    public void testGetRequest02(){
        String url="https://restful-booker.herokuapp.com/booking";
         Response response =given().accept("application/json").when().get(url);
         response.prettyPrint();
         response.then().assertThat().statusCode(200).contentType("application/json");

    }
    @Test
    public void test02(){
        String url="https://restful-booker.herokuapp.com/booking/1001";
        Response response =given().accept("application/json").when().get(url);
        response.prettyPrint();
        response.then().assertThat().statusCode(404);
        Assert.assertTrue(response.asString().contains("Not Found"));
        Assert.assertFalse(response.asString().contains("API"));

    }
}
