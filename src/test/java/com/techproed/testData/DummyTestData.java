package com.techproed.testData;

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
        onbirinciID.put("employee_name","Jena Gaines");
        onbirinciID.put("employee_salary",90560);
        onbirinciID.put("employee_age",30);
        onbirinciID.put("profile_image","");

        HashMap<String, Object> expectedDataMap=new HashMap<String, Object>();

        HashMap<String,Object> expectedData=new HashMap<String, Object>();
        expectedData.put("statusCode",200);
        expectedData.put("besincicalisan","Airi Satou");
        expectedData.put("calisansayisi",24);
        expectedData.put("sondanikincicalisanmaasi",106450);
        expectedData.put("arananYaslar", arananYaslar);
        expectedData.put("onbirincicalisan",onbirinciID);

        return expectedData;


    }
}
