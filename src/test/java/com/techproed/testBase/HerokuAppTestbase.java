package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppTestbase {

protected RequestSpecification spec02;

    //https://restful-booker.herokuapp.com/booking/2
@Before
    public void setUp(){

    spec02=new RequestSpecBuilder()
            .setBaseUri("https://restful-booker.herokuapp.com")
            .build();
}

}
