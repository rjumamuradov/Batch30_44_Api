package com.techproed.testData;

import org.json.JSONObject;

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
    public JSONObject jasonObjectSetUpPostData(){
        //"userId": 55,
        //     "title": "Tidy your room",
        //     "completed": false,

        JSONObject expectedRequest =new JSONObject();

        expectedRequest.put("statusCode",201);
        expectedRequest.put("userId",55);
        expectedRequest.put("title","Tidy your room");
        expectedRequest.put("completed",false);

        return expectedRequest;
    }
}
