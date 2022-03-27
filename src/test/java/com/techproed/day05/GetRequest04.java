package com.techproed.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest04 {

    @Test
    public void GetRequest04(){
        String url="https://restful-booker.herokuapp.com/booking/5";
        Response response= given()
                .accept("application/json")
                .when()
                .get(url);

        response.prettyPrint();
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Sally"),
                        "lastname",equalTo("Brown"),
                        "totalprice",equalTo(662),
                        "bookingdates.checkin",equalTo("2018-08-17"));

    }


}
