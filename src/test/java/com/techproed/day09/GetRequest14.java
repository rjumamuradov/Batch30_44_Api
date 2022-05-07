package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyTestBase {

    /*
 http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
En yüksek maaşın 725000 olduğunu,
En küçük yaşın 19 olduğunu,
İkinci en yüksek maaşın 675000
olduğunu test edin.
  */

    @Test
    public void test() {
        spec03.pathParam("par1", "employees");
        DummyTestData dummyTestData = new DummyTestData();
        HashMap<String, Integer> expectedData = dummyTestData.setUpTestData02();
        System.out.println("expectedData = " + expectedData);

        Response response = given()
                .accept("application/json")
                .spec(spec03)
                .when()
                .get("/{par1}");
        //response.prettyPrint();
        HashMap<String, Object> actualMap = response.as(HashMap.class);
        System.out.println("actualMap = " + actualMap);

        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedData.get("statusCode"), (Integer) response.statusCode());

        //En yüksek maaşın 725000 olduğunu,
        List<Integer> maasListe = new ArrayList<>();
        int dataSize = ((List) actualMap.get("data")).size();

        for (int i = 0; i < dataSize; i++) {
            maasListe.add((Integer) ((Map) ((List) actualMap.get("data")).get(i)).get("employee_salary"));
        }

        Collections.sort(maasListe);
        System.out.println("maasListe = " + maasListe);
        System.out.println("maasListe.get(dataSize-1) = " + maasListe.get(dataSize - 1));
        Assert.assertEquals(expectedData.get("enYuksekMaas"), maasListe.get(maasListe.size() - 1));


        //İkinci en yüksek maaşın 675000
        Assert.assertEquals(expectedData.get("ikinciYuksekMaas"), maasListe.get(dataSize - 2));


        //En küçük yaşın 19 olduğunu test edin.
        List<Integer> yas19 = new ArrayList<>();
        // int yas19Size=((Map)((List<?>) actualMap.get("data")).get(0)).size();
        for (int i = 0; i < dataSize; i++) {
            yas19.add((Integer) ((Map) ((List<?>) actualMap.get("data")).get(i)).get("employee_age"));
        }
        Collections.sort(yas19);
        System.out.println("yas19 = " + yas19);
        Assert.assertEquals(expectedData.get("enKucukYas"), yas19.get(0));

        //jsonPath ile

        JsonPath jsonPath = response.jsonPath();

        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedData.get("statusCode"), ((Integer)response.statusCode()));

        //En yüksek maaşın 725000 olduğunu,
        List<Integer> maasListesiJson=jsonPath.getList("data.employee_salary");
        Collections.sort(maasListesiJson);
        System.out.println("maasListesiJson.get(maasListesiJson.size()-1) = " + maasListesiJson.get(maasListesiJson.size() - 1));
        Assert.assertEquals(expectedData.get("enYuksekMaas"),maasListesiJson.get(maasListesiJson.size()-1));

        //En küçük yaşın 19 olduğunu,
        List<Integer> yasListeJson=jsonPath.getList("data.employee_age");
        Collections.sort(yasListeJson);
        System.out.println("yasListeJson.get(0) = " + yasListeJson.get(0));
        Assert.assertEquals(expectedData.get("enKucukYas"),yasListeJson.get(0));


        //İkinci en yüksek maaşın 675000
        System.out.println("maasListesiJson.get(maasListesiJson.size()-2) = " + maasListesiJson.get(maasListesiJson.size() - 2));
        Assert.assertEquals(expectedData.get("ikinciYuksekMaas"),maasListesiJson.get(maasListesiJson.size()-2));

    }

}