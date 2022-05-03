package com.techproed.day08;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.testData.HerokuAppTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuAppTestBase {
     /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
{
 "firstname": "Mary",
    "lastname": "Ericsson",
    "totalprice": 301,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2015-11-05",
        "checkout": "2021-08-22"
    },
    "additionalneeds": "Breakfast"
     */

    @Test
    public void test() {
        spec02.pathParams("par1", "booking", "par2", "1");

        HerokuAppTestData expectedObje = new HerokuAppTestData();
        HashMap<String, Object> expectedDataMap = expectedObje.setUpData();
        System.out.println("expectedDataMap = " + expectedDataMap);

        Response response = given()
                .accept("application/json")  //ContentType.JSON I'm a teapot yazar'
                .spec(spec02)
                .when()
                .get("/{par1}/{par2}");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));

        Assert.assertEquals(((Map) expectedDataMap
                        .get("bookingdates"))
                        .get("checkin")
                , ((Map) actualDataMap
                        .get("bookingdates"))
                        .get("checkin"));

        Assert.assertEquals(((Map) expectedDataMap
                        .get("bookingDates"))
                        .get("checkout")
                , ((Map) actualDataMap
                        .get("bookingdates"))
                        .get("checkout"));

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("firstname"), jsonPath.getString("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), jsonPath.getString("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), jsonPath.getInt("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"), jsonPath.getBoolean("depositpaid"));
        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkin"),
                jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals(((Map) expectedDataMap.get("bookingdates")).get("checkout"),
                jsonPath.getString("bookingdates.checkout"));

    }

}
