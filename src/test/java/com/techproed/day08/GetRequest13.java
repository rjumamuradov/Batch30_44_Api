package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {

    @Test
    public void test() {
        spec03.pathParam("par1","employees");

        DummyTestData expectedObje=new DummyTestData();
        HashMap<String, Object> expectedMap=expectedObje.setUpTestData();
        System.out.println("expectedMap = " + expectedMap);

        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        response.prettyPrint();
    }


}
