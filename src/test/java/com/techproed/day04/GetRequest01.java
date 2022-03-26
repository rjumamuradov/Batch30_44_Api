package com.techproed.day04;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void testGetRequest01() {
        String url="https://restful-booker.herokuapp.com/booking/3;";
       Response response= given().accept("application/json").when().get(url);

        response.prettyPrint();
    }






}
