package com.techproed.day07;

import com.techproed.testBase.DummyTestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest10 extends DummyTestBase {
    @Test
    public void testGetRequest10() {

        spec03.pathParam("par1", "employees");
        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");

        JsonPath jsonPath = response.jsonPath();
//id 10dan buyukleri yazdir
        List<Integer> idlist = jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println("idlist.size() = " + idlist.size());
        System.out.println("idlist = " + idlist);
//30dan kucugu yazdir
        List<Integer> ageList = jsonPath.getList("data.findAll{it.employee_age<63}.employee_age");
        System.out.println("ageList.size() = " + ageList.size());
        System.out.println("ageList = " + ageList);
//siralama
        Collections.sort(ageList);
        System.out.println("ageList = " + ageList);

        //son siradaki 61?

       // Assert.assertEquals((Integer) 61, ageList.get(ageList.size() - 1));
       // Assert.assertEquals(61, (int) ageList.get(ageList.size() - 1));


        // maasi 30.000 fazla olan write employee_name

        List<String> salaryList01 = jsonPath.getList("data.findAll{it.employee_salary>30000}.employee_name");
        System.out.println("yuksekMaasliIsimListe = " + salaryList01);
        //Assert.assertTrue(salaryList01.contains("Chandler"));

        List<Integer> salaryList02 = jsonPath.getList("data.findAll{it.employee_salary>30000}.employee_name");
        System.out.println("salaryList02 = " + salaryList02);
        Assert.assertTrue(salaryList02.contains("Chandler"));
    }
}
