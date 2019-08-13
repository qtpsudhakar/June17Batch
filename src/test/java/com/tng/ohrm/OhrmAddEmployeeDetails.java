package com.tng.ohrm;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.pom.AddEmployeePage;
import com.wd.pom.AddEmployeeSteps;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WelcomePage;

public class OhrmAddEmployeeDetails extends OhrmTestBase{

	@Test
	public void OhrmAddEMployeeWithDetails() {
		AddEmployeeSteps employee = new AddEmployeeSteps();
		employee.Login();
		employee.AddEmployee();
		
	}
		
}
