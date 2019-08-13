package com.tng.ohrm;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.pom.AddEmployeePage;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WelcomePage;

public class OhrmAddEmployee_DDT_HashMap extends OhrmTestBase{

	@Test
	public void Login() {
		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLoginButton();
		//Assert.fail("Login failed");
	}

	@Test(dependsOnMethods = "Login",dataProvider="getEmpDataMapExcel",dataProviderClass=OhrmDP.class)
	public void AddEmployee(HashMap<String, String> empData) {
		WelcomePage welcomePage = new WelcomePage();

		welcomePage.clickOnPIM();
		welcomePage.clickOnAddEmployee();

		AddEmployeePage addEmployeePage = new AddEmployeePage();

		addEmployeePage.enterFirstName(empData.get("firstName"));
		addEmployeePage.enterLastName(empData.get("lastName"));
		addEmployeePage.clickOnSaveButton();
	}
}
