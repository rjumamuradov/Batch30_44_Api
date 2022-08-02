package com.techproed.day12;

import com.techproed.pojos.TodosPojo;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequest01 extends JsonPlaceHolderTestBase {

      /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
 Request body{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
 Status kodun 201, response body ‘nin ise
{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 }
     */

    @Test
    public void test01(){
        spec01.pathParams("par1","todos");

        TodosPojo requestExpected=new TodosPojo(21,201,"tidy your room bro",false);

        System.out.println("requestExpected = " + requestExpected);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec01)
                .auth()
                .basic("admin","password123")
                .body(requestExpected)
                .when()
                .post("/{par1}");

        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        //De Sterialization

        TodosPojo actualData=response.as(TodosPojo.class);
        System.out.println("actualData = " + actualData);
        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(requestExpected.getId(),actualData.getId());
        Assert.assertEquals(requestExpected.getUserId(),actualData.getUserId());
        Assert.assertEquals(requestExpected.getTitle(),actualData.getTitle());
        Assert.assertEquals(requestExpected.isCompleted(),actualData.isCompleted());

    }
}
