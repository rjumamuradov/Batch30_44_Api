package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {
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
        spec03.pathParam("par1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Object> expectedMap = expectedObje.setUpTestData();
        System.out.println("expectedMap = " + expectedMap);

        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        response.prettyPrint();

        HashMap<String, Object> actualMap = response.as(HashMap.class);

        System.out.println("actualMap = " + actualMap);
//          5. Çalışan isminin "Airi Satou" olduğunu ,
        Assert.assertEquals(expectedMap.get("besincicalisan")
                , ((Map) ((List) actualMap.get("data")).get(4)).get("employee_name"));

//          çalışan sayısının 24 olduğunu,
        Assert.assertEquals(expectedMap.get("calisansayisi"),
                ((List) actualMap.get("data")).size());

        //        Sondan 2. çalışanın maaşının 106450 olduğunu

        int dataSize = ((List) actualMap.get("data")).size();
        Assert.assertEquals(expectedMap.get("sondanikincicalisanmaasi")
                , ((Map) ((List) actualMap.get("data")).get(dataSize - 2)).get("employee_salary")
        );
//40,21 ve 19 yaslarında çalışanlar olup olmadığını

        List<Integer> actualAgeList = new ArrayList<Integer>();

        for (int i = 0; i < dataSize; i++) {
            actualAgeList.add((Integer) ((Map) ((List<?>) actualMap.get("data")).get(i)).get("employee_age"));
        }

        Assert.assertTrue(actualAgeList.containsAll(((List) expectedMap.get("arananYaslar"))));


        /*“id”:”11”
            "employee_name": "Jena Gaines",
                "employee_salary": "90560",
                "employee_age": "30",
                "profile_image": "" }
    } gibi olduğunu test edin.
    */
        Assert.assertEquals( ((Map)expectedMap.get("onbirincicalisan")).get("employee_name")
        ,((Map)((List<?>) actualMap.get("data")).get(10)).get("employee_name")
                );


    }


}
