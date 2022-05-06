package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest13_MathcherClass extends DummyTestBase {
    /*
           http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
           Status kodun 200 olduğunu,
             5. Çalışan isminin "Airi Satou" olduğunu ,
             çalışan sayısının 24 olduğunu,
           Sondan 2. çalışanın maaşının 106450 olduğunu
       40,21 ve 19 yaslarında çalışanlar olup olmadığını
       11. Çalışan bilgilerinin
           {
        “id”:”11”
               "employee_name": "Jena Gaines",
                   "employee_salary": "90560",
                   "employee_age": "30",
                   "profile_image": "" }
       } gibi olduğunu test edin.
       */
    @Test
    public void test() {
        DummyTestData dummyTestData = new DummyTestData();
        HashMap<String, Object> expectedMap = new HashMap<String, Object>();
        spec03.pathParam("par1", "employees");
        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        //response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode((Integer) expectedMap.get("statusCode"))   // Status kodun 200 olduğunu,
                .body("data[4].employee_name", equalTo(expectedMap.get("besincicalisan"))          //  5. Çalışan isminin "Airi Satou" olduğunu ,
                        , "data.id", hasSize((Integer) expectedMap.get("calisansayisi"))    // çalışan sayısının 24 olduğunu,
                        , "data[-2].employee_salary", equalTo(expectedMap.get("sondanikincicalisanmaasi"))  // Sondan 2. çalışanın maaşının 106450 olduğunu
                        ,"data.employee_age", hasItems(((List)expectedMap.get("arananYaslar")).get(0)   //40,21 ve 19 yaslarında çalışanlar olup olmadığını
                                ,((List<?>) expectedMap.get("arananYaslar")).get(1))
                        ,((List<?>) expectedMap.get("arananYaslar")).get(2)
                        ,"data[10].employee_name",equalTo(((Map)expectedMap.get("onbirinciID")).get("employee_name"))
                        ,"data[10].employee_age",equalTo(((Map)expectedMap.get("onbirinciID")).get("employee_age"))
                        ,"data[10].employee_salary",equalTo(((Map)expectedMap.get("onbirinciID")).get("employee_salary"))
                        ,"data[10].profile_image",equalTo(((Map)expectedMap.get("onbirinciID")).get("profile_image"))



                );


    }


}
