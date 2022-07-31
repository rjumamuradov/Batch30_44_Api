package com.techproed.testData;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyTestData {
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

    public HashMap<String, Object> setUpTestData() {
        List<Integer> arananYaslar = new ArrayList<Integer>();
        arananYaslar.add(40);
        arananYaslar.add(21);
        arananYaslar.add(19);


        HashMap<String, Object> onbirinciID = new HashMap<String, Object>();
        onbirinciID.put("id", 1);
        onbirinciID.put("employee_name", "Jena Gaines");
        onbirinciID.put("employee_salary", 90560);
        onbirinciID.put("employee_age", 30);
        onbirinciID.put("profile_image", "");

        HashMap<String, Object> expectedDataMap = new HashMap<String, Object>();

        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("besincicalisan", "Airi Satou");
        expectedData.put("calisansayisi", 24);
        expectedData.put("sondanikincicalisanmaasi", 106450);
        expectedData.put("arananYaslar", arananYaslar);
        expectedData.put("onbirincicalisan", onbirinciID);

        return expectedData;


    }

    public HashMap<String, Integer> setUpTestData02() {
 /*
 http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
En yüksek maaşın 725000 olduğunu,
En küçük yaşın 19 olduğunu,
İkinci en yüksek maaşın 675000
olduğunu test edin.
  */
        HashMap<String, Integer> expectedData = new HashMap<String, Integer>();
        expectedData.put("statusCode", 200);
        expectedData.put("enYuksekMaas", 725000);
        expectedData.put("enKucukYas", 19);
        expectedData.put("ikinciYuksekMaas", 675000);
        return expectedData;
    }

    public HashMap<String, String> setUpRequestBody() {
        // "name":"Ahmet Aksoy",
        // "salary":"1000",
        // "age":"18",

        HashMap<String, String> requestbody = new HashMap<String, String>();
        requestbody.put("name", "batch44+");
        requestbody.put("salary", "50000");
        requestbody.put("age", "30");


        return requestbody;
    }

    public HashMap<String, Object> setUpExpectedData() {
        HashMap<String, Object> data = new HashMap<>();
      // data.put("name", "batch44+");
      // data.put("salary", "50000");
      // data.put("age", "30");


        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("status", "success");
       // expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been added.");

        return expectedData;
    }
    public JSONObject setUpDeleteExpectedData(){
        /*
        {
 "status": "success",
 "data": "2",
 "message": "Successfully! Record has been deleted"
 }
         */

        JSONObject expectedData=new JSONObject();

        expectedData.put("status", "success");
        expectedData.put("data", "2");
        expectedData.put("message", "Successfully! Record has been deleted");
        return expectedData;


    }
}
