package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {
    @Test
    public void testGetRequest01() {
        String url="https://restful-booker.herokuapp.com/booking/3;";
       Response response= given()
               .accept("application/json")
               .when()
               .get(url);

        response.prettyPrint();
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.getContentType() = " + response.getContentType());
        System.out.println("response.getStatusLine() = " + response.getStatusLine());

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());


        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");



    }






}
