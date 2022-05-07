package com.techproed.day10;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.jar.JarEntry;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends DummyTestBase {

    /*
    http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
{
 "name":"Ahmet Aksoy",
 "salary":"1000",
 "age":"18",
  }
gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
{
 "status": "success",
 "data": {
 “id”:…
 },
 "message": "Successfully! Record has been added."
 }
olduğunu test edin
     */

    @Test
    public void test01() {
        spec03.pathParam("par1", "create");
        DummyTestData objeDummy = new DummyTestData();
        HashMap<String, String> requestBodyMap = objeDummy.setUpRequestBody();
        HashMap<String, Object> expectedDataMap = objeDummy.setUpExpectedData();

        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .auth()
                .basic("admin","pasword123")
                .body(requestBodyMap)
                .when()
                .post("/{par1}");

        response.prettyPrint();

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        Assert.assertEquals(expectedDataMap.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedDataMap.get("status"),actualDataMap.get("status"));
        Assert.assertEquals(expectedDataMap.get("message"),actualDataMap.get("message"));

        //JsonPath ile
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("status"),jsonPath.getString("status"));
        Assert.assertEquals(expectedDataMap.get("message"),jsonPath.getString("message"));
    }
}
