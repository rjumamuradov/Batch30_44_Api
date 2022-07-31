package com.techproed.day12;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletedRequest extends DummyTestBase {

    /*
  http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"status": "success",
"data": "2",
"message": "Successfully! Record has been deleted"
}
   */
    @Test
    public void test1() {
    spec03.pathParams("par1","delete",
            "par2",2);

        DummyTestData testData =new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec03)
                .auth()
                .basic("admin","pasword123")
                .when()
                .delete("/{par1}/{par2}");
        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        response.then().
                assertThat().
                statusCode(200).
                body("status", equalTo(expectedData.getString("status")),
                        "data",equalTo(expectedData.getString("data")),
                        "message",equalTo(expectedData.getString("message")));

        System.out.println("response.prettyPrint() = " + response.prettyPrint());


    }
}
