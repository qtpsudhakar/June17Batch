package com.wd.pom;

public class AddEmployeeSteps {

	LoginPage loginPage = new LoginPage();
	AddEmployeePage addEmployeePage = new AddEmployeePage();
	WelcomePage welcomePage = new WelcomePage();

	public void Login() {
		try {
			loginPage.enterUserName("admin");
			loginPage.enterPassword("admin123");
			loginPage.clickLoginButton();
		} catch (RuntimeException e) {
			
			throw e;
		}
	}
	
	public void AddEmployee() {
		try {
			welcomePage.clickOnPIM();
			welcomePage.clickOnAddEmployee();

			AddEmployeePage addEmployeePage = new AddEmployeePage();

			addEmployeePage.enterFirstName("selenium");
			addEmployeePage.enterLastName("hq");
			addEmployeePage.clickOnSaveButton();

		} catch (RuntimeException e) {
			
			throw e;
		}
	}
}
