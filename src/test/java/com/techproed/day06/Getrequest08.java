package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Getrequest08 extends DummyTestBase {

    @Test
    public void getRequest08() {

        spec03.pathParam("par3", "employees");
        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par3}");

        //response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        System.out.println("jsonPath.getList(\"data.employee_name\") = " + jsonPath.getList("data.employee_name"));
        System.out.println("jsonPath.getString(\"data.employee_name\") = " + jsonPath.getString("data.employee_name"));
        System.out.println("jsonPath.get(\"data.employee_name\") = " + jsonPath.get("data.employee_name"));
        System.out.println("jsonPath.get(\"data2.employee_name\") = " + jsonPath.getString("data[2].employee_name"));
        System.out.println("jsonPath.get(\"data3.employee_name\") = " + jsonPath.getString("data.employee_name[3]"));

        System.out.println("jsonPath.getString(\"data.employee_name[1,2,3,4,5,6,7]\") = "
                + jsonPath.getString("data.employee_name[1,2,3,4,5,6,7]"));


        System.out.println("jsonPath.getString(\"data.employee_name[-1]\") = " + jsonPath.getString("data.employee_name[-1]"));
    }
}
