package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String, Object> setUpTestdata() {
        HashMap<String, Object> expectedData = new HashMap<String, Object>();
        expectedData.put("statusCode", 200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("complated", "false");
        expectedData.put("userId", 1);
        //System.out.println("expectedData = " + expectedData);
        return expectedData;

    }

    public JSONObject setUpPostData() {
        //"userId": 55,
        //     "title": "Tidy your room",
        //     "completed": false,

        JSONObject expectedRequest = new JSONObject();

        expectedRequest.put("statusCode", 201);
        expectedRequest.put("userId", 55);
        expectedRequest.put("title", "Tidy your room");
        expectedRequest.put("completed", false);

        return expectedRequest;
    }

    public JSONObject setUpPutData() {
        JSONObject expectedRequest = new JSONObject();

        expectedRequest.put("userId", 17);
        expectedRequest.put("title", "wash the dish bro");
        expectedRequest.put("complated", "false");
        return expectedRequest;
    }

    public JSONObject setUpPatchRequestData() {
        JSONObject requestData = new JSONObject();
        requestData.put("title", "API calismaliyim");
        return requestData;
    }

    public JSONObject setUpPatchExpectedData() {
        /*
        "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
         */

        JSONObject expectedData= new JSONObject();
        expectedData.put("userId", 10);
        expectedData.put("title", "API calismaliyim");
        expectedData.put("completed", true);
        expectedData.put( "id", 198);

        return expectedData;
    }


}
