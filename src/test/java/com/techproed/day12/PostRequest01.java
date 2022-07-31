package com.techproed.day12;

import com.techproed.pojos.TodosPojo;
import com.techproed.testBase.JsonPlaceHolderTestBase;
import org.junit.Test;

public class PostRequest01 extends JsonPlaceHolderTestBase {

      /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
 Request body{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
 Status kodun 201, response body ‘nin ise
{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 }
     */

    @Test
    public void test01(){
        spec01.pathParams("par1","todos");

        TodosPojo requestExpected=new TodosPojo(21,201,"tidy your room bro",false);

        System.out.println("requestExpected = " + requestExpected);
    }
}
