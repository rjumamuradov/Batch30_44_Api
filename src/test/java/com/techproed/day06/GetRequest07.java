package com.techproed.day06;

import com.techproed.testBase.HerokuAppTestbase;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class GetRequest07 extends HerokuAppTestbase {
    Response response;

//https://restful-booker.herokuapp.com/booking/5


    @Test
    public void GetRequest07() {

    spec02.pathParams("par1","booking","par2","5");
    response=given()
            .accept("application/json")
            .spec(spec02)
            .when()
            .get("/{par1}/{par2}");

        Assert.assertEquals(200,response.getStatusCode());
    }

}
