package com.tests;


import org.testng.annotations.Test;

import com.pages.AddEmployeePage;
import com.pages.LoginPage;
import com.pages.WelcomePage;

public class OhrmAddEmployee extends OhrmTestBase{

	@Test
	public void Login() {
		LoginPage loginPage = new LoginPage();

		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLoginButton();
		//Assert.fail("Login failed");
	}

	@Test(dependsOnMethods = "Login")
	public void AddEmployee() {
		WelcomePage welcomePage = new WelcomePage();

		welcomePage.clickOnPIM();
		welcomePage.clickOnAddEmployee();

		AddEmployeePage addEmployeePage = new AddEmployeePage();

		addEmployeePage.enterFirstName("selenium");
		addEmployeePage.enterLastName("hq");
		addEmployeePage.clickOnSaveButton();
	}
}
