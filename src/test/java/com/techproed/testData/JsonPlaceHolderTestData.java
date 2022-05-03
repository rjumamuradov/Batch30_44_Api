package com.techproed.testData;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object> setUpTestdata(){
        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode",  200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("complated", "false");
        expectedData.put("userId", 1);
        //System.out.println("expectedData = " + expectedData);
        return expectedData;

    }
}
