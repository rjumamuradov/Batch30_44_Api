package com.techproed.day10;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.testData.HerokuAppTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends HerokuAppTestBase {
/*
    https://restful-booker.herokuapp.com/booking
    { "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
 }
 gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
 "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2020-09-01",
              "checkout": " 2020-09-21”
         },
        }
olduğunu test edin
     */


    @Test
    public void test() {

        spec02.pathParam("par1", "booking");
        HerokuAppTestData testData = new HerokuAppTestData();
        JSONObject expectedJsonObject = testData.setUptestAndRequestData();
        System.out.println("expectedJsonObject = " + expectedJsonObject);
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(spec02)
                .auth()
                .basic("admin", "password123")
                .body(expectedJsonObject.toString())
                .when()
                .post("/{par1}");
        response.prettyPrint();

        //De serilization yontemi ile  JsonObject

        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        //"firstname": " Selim ",
        Assert.assertEquals(expectedJsonObject.getString("firstname"), ((Map) actualDataMap.get("booking")).get("firstname"));

        //         "lastname": " Ak ",
        Assert.assertEquals(expectedJsonObject.getString("lastname"), ((Map) actualDataMap.get("booking")).get("lastname"));

        //         "totalprice":  11111,
        Assert.assertEquals(expectedJsonObject.getInt("totalprice"), ((Map<?, ?>) actualDataMap.get("booking")).get("totalprice"));

        //         "depositpaid": true,
        Assert.assertEquals(expectedJsonObject.getBoolean("depositpaid"), ((Map<?, ?>) actualDataMap.get("booking")).get("depositpaid"));

        //         "bookingdates": {
        //             "checkin": "2020-09-01",
        Assert.assertEquals(expectedJsonObject.getJSONObject("bookingdates").getString("checkin")
                , ((Map) ((Map<?, ?>) actualDataMap.get("booking")).get( "bookingdates")).get("checkin"));

        //              "checkout": " 2020-09-21”
        Assert.assertEquals(expectedJsonObject.getJSONObject("bookingdates").getString("checkout")
                ,((Map) ((Map<?, ?>) actualDataMap.get("booking")).get( "bookingdates")).get("checkout"));

        //JsonPath yontemi

        JsonPath actualJsonPathData=response.jsonPath();


        //"booking": {
        //         "firstname": " Selim ",
        Assert.assertEquals(expectedJsonObject.getString("firstname"),actualJsonPathData.getString("booking.firstname"));

        //         "lastname": " Ak ",
        Assert.assertEquals(expectedJsonObject.getString("lastname"),actualJsonPathData.getString("booking.lastname"));

        //         "totalprice":  11111,
        Assert.assertEquals(expectedJsonObject.getInt("totalprice"),actualJsonPathData.getInt("booking.totalprice"));

        //         "depositpaid": true,
        Assert.assertEquals(expectedJsonObject.getBoolean("depositpaid"),actualJsonPathData.getBoolean("booking.depositpaid"));

        //         "bookingdates": {
        //             "checkin": "2020-09-01",
        Assert.assertEquals(expectedJsonObject.getJSONObject("bookingdates").getString("checkin")
                ,actualJsonPathData.getString("booking.bookingdates.checkin"));

        //              "checkout": " 2020-09-21”
        Assert.assertEquals(expectedJsonObject.getJSONObject("bookingdates").getString("checkout")
                ,actualJsonPathData.getString("booking.bookingdates.checkout"));

        //         },
        //        }

    }
}
