package com.techproed.day05;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {
    @Test
    public void teest01(){
        String url="https://jsonplaceholder.typicode.com/todos";

        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();



    }

}
