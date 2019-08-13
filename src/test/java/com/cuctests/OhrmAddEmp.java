package com.cuctests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "src/test/resources/Features", tags="@login",glue = {"com.cuc"}) 
public class OhrmAddEmp extends AbstractTestNGCucumberTests{
  
}
