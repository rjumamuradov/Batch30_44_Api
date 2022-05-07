package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13_JsonPath extends DummyTestBase {


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
    public void testGetRequest130() {
        spec03.pathParam("par1", "employees");

        DummyTestData dummyTestData = new DummyTestData();
        HashMap<String, Object> expectedMap = dummyTestData.setUpTestData();
        System.out.println("expectedMap = " + expectedMap);
        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        // status code
        Assert.assertEquals(expectedMap.get("statusCode"), response.statusCode());

        //                 5. Çalışan isminin "Airi Satou" olduğunu ,
        Assert.assertEquals(expectedMap.get("besincicalisan"), jsonPath.getString("data[4].employee_name"));

        //calisan sayisi
        Assert.assertEquals(expectedMap.get("calisansayisi"), jsonPath.getList("data.id").size());

        //sondanikincicalisanmaasi
        Assert.assertEquals(expectedMap.get("sondanikincicalisanmaasi")
                , jsonPath.getInt("data[-2].employee_salary"));

        //           40,21 ve 19 yaslarında çalışanlar olup olmadığını
        Assert.assertTrue(jsonPath.getList("data.employee_age")
                .containsAll((Collection<?>) expectedMap.get("arananYaslar")));

        //11.calisan                    "employee_name": "Jena Gaines",
        Assert.assertEquals(((Map) expectedMap.get("onbirinciID")).get("employee_name")
                , jsonPath.getString("data[10].employee_name"));
        //id
        Assert.assertEquals(((Map<?, ?>) expectedMap.get("onbirinciID")).get("id"), jsonPath.getInt("data[10].id"));

        //employee_salary
        Assert.assertEquals(((Map<?, ?>) expectedMap.get("onbirinciID")).get("employee_salary"), jsonPath.getInt("data[10].employee_salary"));

        //employee_age
        Assert.assertEquals(((Map<?, ?>) expectedMap.get("onbirinciID")).get("employee_age"), jsonPath.getInt("data[10].employee_age"));

        //profile_image
        Assert.assertEquals(((Map<?, ?>) expectedMap.get("onbirinciID")).get("profile_image"), jsonPath.getString("data[10].profile_image"));

    }


}
