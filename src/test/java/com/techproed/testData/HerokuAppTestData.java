package com.techproed.testData;

import java.util.HashMap;

public class HerokuAppTestData {
          /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
{
 "firstname": "Mary",
    "lastname": "Ericsson",
    "totalprice": 301,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2015-11-05",
        "checkout": "2021-08-22"
    },
    "additionalneeds": "Breakfast"
     */


    public HashMap<String, Object> setUpData() {
        HashMap<String, Object> bookingDates = new HashMap<String, Object>();
        bookingDates.put("checkin","2015-08-16");
        bookingDates.put("checkout","2020-10-13");

    HashMap<String, Object> expectedData=new HashMap<String, Object>();
        expectedData.put("firstname","Jim");
        expectedData.put("lastname","Brown");
        expectedData.put("totalprice",207);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDates);
        expectedData.put("additionalneeds","Breakfast");

        return expectedData;

        }

}
