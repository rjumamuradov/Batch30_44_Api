package com.techproed.day11;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import com.techproed.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest03 extends JsonPlaceHolderTestBase {
     /*
    https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
     */

    @Test
    public void test(){
        spec01.pathParam("par1","todos");

     //   Response response=given()
     //           .contentType(ContentType.JSON)
     //           .auth()
     //           .basic("admin","password")
     //           .body();
        JsonPlaceHolderTestData obje=new JsonPlaceHolderTestData();

        JSONObject jsonObjectExpected =obje.jasonObjectSetUpPostData();
        System.out.println("jsonObjectExpected = " + jsonObjectExpected);

        Response response=given()
                .accept(ContentType.JSON)
                .spec(spec01)
                .auth()
                .basic("admin","password123")
                .body(jsonObjectExpected.toString())
                .when()
                .post("/{par1}");
        response.prettyPrint();

    }
}
