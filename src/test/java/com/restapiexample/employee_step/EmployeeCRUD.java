package com.restapiexample.employee_step;

import com.restapiexample.emploeesteps.EmployeeSteps;
import com.restapiexample.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@RunWith(SerenityRunner.class)
public class EmployeeCRUD extends TestBase {
    ValidatableResponse response;
    static  String name="My Name";
    static String salary="55000";
    static String age="22";
    static int id;

@Steps
    EmployeeSteps employeeSteps;


@Title("This will create a new service")
    @Test
    public void test001(){
     response=employeeSteps.createEmployee(name,salary,age);
    response.log().all().statusCode(200);
    id= response.log().all().extract().path("data.id");
    System.out.println(id);
    }

    @Title("Verify if the employee was added to ath application")
    @Test
    public void test002(){



//        HashMap<String,Object> employeeMap= employeeSteps.getEmployeeInfoById(id);
//        System.out.println(employeeMap);

         response = employeeSteps.getEmployeeInfoByIdAndReturnResponse(id);
        System.out.println(response);
        String name_Extracted;
        name_Extracted= response.log().all().extract().path("data.employee_name");
        System.out.println(name_Extracted);
    }

    @Title("Update the employee information and verify that the information has been updated")
    @Test
    public void test003(){
    name =name +"_Updated";
    ValidatableResponse response =employeeSteps.updateEmployeeDetails(id,name,salary,age);
    response.log().all().statusCode(200);

    }
    @Title("Delete the employee and verify if the employee is deleted!")
    @Test
    public void test004(){

//    employeeSteps.deleteEmployee(id).statusCode(200);
//    employeeSteps.getEmployeeInfoByIdAndReturnResponse(id).statusCode(404);


    }



}
