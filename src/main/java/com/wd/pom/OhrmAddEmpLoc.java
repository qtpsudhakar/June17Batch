package com.wd.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wd.util.DriverFactory;

public class OhrmAddEmpLoc {
	
	public static void main(String[] args) {
		
		OhrmBase orangeHrm = new OhrmBase();
		orangeHrm.OpenApplication("chrome");
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin123");
		loginPage.clickLoginButton();
		
		WelcomePage welcomePage = new WelcomePage();
		
		welcomePage.clickOnPIM();
		welcomePage.clickOnAddEmployee();
		
		AddEmployeePage addEmployeePage = new AddEmployeePage();
		
		addEmployeePage.enterFirstName("selenium");
		addEmployeePage.enterLastName("hq");
		addEmployeePage.clickOnSaveButton();
		
		PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
		personalDetailsPage.clickOnEditButton();
		personalDetailsPage.selectCountry("Indian");
		personalDetailsPage.selectCountry(10);
		orangeHrm.closeApplication();
		
		
	}
}









