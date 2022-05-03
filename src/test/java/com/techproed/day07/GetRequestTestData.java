package com.techproed.day07;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestTestData extends JsonPlaceHolderTestBase {
    @Test
    public void test01() {
        spec01.pathParams("par1", "todos", "par2", 2);

        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode",  200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("complated", "false");
        expectedData.put("userId", 1);
        System.out.println("expectedData = " + expectedData);

        Response response = given()
                .accept("application/json")
                .spec(spec01)
                .when()
                .get("/{par1}/{par2}");
        response.prettyPrint();

        response.then().assertThat().statusCode((Integer)expectedData.get("statusCode")).
                headers("via", equalTo(expectedData.get("via")),
                        "Server",equalTo(expectedData.get("Server")));
        //body("userId",equalTo(expectedData.get("userId")),
        //        "title",equalTo(expectedData.get("title")),
        //        "completed",equalTo(expectedData.get("completed")));


        //2.yontem
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"), response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.header("via"));
        //Assert.assertEquals(expectedData.get("via"),jsonPath.getList( "via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),jsonPath.getString("title"));
        //Assert.assertEquals(expectedData.get("completed"),jsonPath.getBoolean("completed"));


        //3. yöntem  deserialization

        HashMap<String, Object> actualData =response.as(HashMap.class);


        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
        //   --object mapper
        //   --pojo class ile birlite map

    }


}
