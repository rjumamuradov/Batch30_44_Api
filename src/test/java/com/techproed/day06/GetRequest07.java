package com.techproed.day06;

import com.techproed.testBase.HerokuAppTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest07 extends HerokuAppTestBase {
    Response response;

//https://restful-booker.herokuapp.com/booking/5


    @Test
    public void getRequest07() {

    spec02.pathParams("par1","booking","par2","5");
    response=given()
            .accept("application/json")
            .spec(spec02)
            .when()
            .get("/{par1}/{par2}");

        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("Susan",jsonPath.getString("firstname"));
        System.out.println("jsonPath.getString(\"firstname\") = " + jsonPath.getString("firstname"));


        Assert.assertEquals("Susan",jsonPath.get("firstname"));
        System.out.println("jsonPath.get(\"firstname\") = " + jsonPath.get("firstname"));
    }

}
