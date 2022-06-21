package com.restapiexample.employee_step;

import com.restapiexample.constants.EndPoints;
import com.restapiexample.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;
import org.junit.runner.RunWith;


public class FirstSerenity extends TestBase {

@Test
    public void getAllEmployees(){

    SerenityRest.given()
            .when()
            .get(EndPoints.GET_EMPLOYEES)
            .then()
            .log().all()
            .statusCode(200);

}
}
