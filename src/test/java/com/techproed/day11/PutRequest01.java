package com.techproed.day11;


import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderTestBase {
      /*
      URL ine aşağıdaki body gönerdiğimde
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false
 }
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
 }
     */

    @Test
    public void test01(){
    spec01.pathParams("par1","todos","par2",198);

        JsonPlaceHolderTestData testObje=new JsonPlaceHolderTestData();
        JSONObject expectedRequest=testObje.setUpPutData();
        System.out.println("expectedRequest = " + expectedRequest);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .auth().basic("admin","password123")
                .body(expectedRequest.toString())
                .when()
                .put("/{par1}/{par2}");
        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        //expected ile response eslesiyor mu diye dogrulama yap

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedRequest.getInt("userId"),jsonPath.getInt("userId"));
        Assert.assertEquals(expectedRequest.getString("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedRequest.getBoolean("complated"),jsonPath.getBoolean("complated"));
        Assert.assertEquals(200,response.statusCode());


    }
}
