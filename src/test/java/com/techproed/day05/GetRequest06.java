package com.techproed.day05;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest06 extends JsonPlaceHolderTestBase {
    Response response;
    @Test
    public void teest01(){
        String url="https://jsonplaceholder.typicode.com/todos";

        Response response=given().accept("application/json").when().get(url);
        response.prettyPrint();

        //https://jsonplaceholder.typicode.com/todos/123
        spec01.pathParams("parametre1", "todos", "parametre2", "123");

        response =given()
                .accept("application/json")
                .spec(spec01)
                .when()
                .get("/{parametre1}/{parametre2}");
        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Server",equalTo("cloudflare"))
                .body("userId",equalTo(7)
                        ,"title",equalTo("esse et quis iste est earum aut impedit")
                        ,"completed",equalTo(false));



    }

}
