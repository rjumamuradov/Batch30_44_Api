package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest09 extends DummyTestBase {


    @Test
    public void GetRequest09() {

        spec03.pathParam("par1", "employees");
        Response response = given().accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        JsonPath jsonPath= response.jsonPath();
       response.prettyPrint();
       // System.out.println("jsonPath.getList() = " + jsonPath.getList(""));

      // Assert.assertEquals(200,response.getStatusCode());
       //Assert.assertEquals(61,jsonPath.getInt("data.employee_age"));

        System.out.println("jsonPath.getList(\"data.id\").size() = " + jsonPath.getList("data.id").size());
        Assert.assertEquals("24 degil",24,jsonPath.getList("data.id").size());

        //5.elemanin ismi
       // Assert.assertEquals("Airi Satou",jsonPath.getList("data[4].employees_name"));
//6. elemanin maasi
        Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));

        System.out.println("jsonPath.getString(\"data.employee_name\").contains(\"Chandler\") = "
                + jsonPath.getString("data.employee_name").contains("Chandler"));
        Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Tiger"));


        //containsAll

        List<Integer> ageList = new ArrayList<Integer>();
        ageList.add(18);
        ageList.add(33);
        ageList.add(40);
        ageList.add(63);
        System.out.println("jsonPath.getList(\"data.employee_age\").containsAll() = "
                + jsonPath.getList("data.employee_age").containsAll(ageList));
    }
}
