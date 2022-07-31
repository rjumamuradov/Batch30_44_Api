package com.techproed.day12;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderTestBase {

     /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
   {
      "title": "API calismaliyim"
     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
}
     */

    @Test
    public void test01(){

        spec01.pathParams("par1","todos","par2",198);

        JsonPlaceHolderTestData testData=new JsonPlaceHolderTestData();
        JSONObject requestData=testData.setUpPatchRequestData();
        System.out.println("requestData = " + requestData);

        JSONObject expectedData=testData.setUpPatchExpectedData();
        System.out.println("expectedData = " + expectedData);

        // Request gonder

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .auth()
                .basic("admin","pasword123")
                .body(requestData.toString())
                .when()
                .patch("/{par1}/{par2}");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        //De Serialization

        HashMap<String,Object> actualData=response.as(HashMap.class);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getInt("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.getInt("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.getString("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.getBoolean("completed"),actualData.get("completed"));


    }
}
