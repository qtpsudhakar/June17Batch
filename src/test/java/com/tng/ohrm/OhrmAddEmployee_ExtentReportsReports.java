package com.tng.ohrm;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.wd.pom.AddEmployeePage;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WebUtil;
import com.wd.pom.WelcomePage;
import com.wd.util.DataUtil;

public class OhrmAddEmployee_ExtentReportsReports {
	OhrmBase orangeHrm;
	WelcomePage welcomePage;

	ExtentReports extent = new ExtentReports();
	ExtentTest test;

	@BeforeClass
	public void openApplication() {
		try {
			String clsName = this.getClass().getSimpleName();
			ExtentHtmlReporter extHtml = new ExtentHtmlReporter("src/../Reports/" + clsName+DataUtil.getUniqueId() + ".html");
			extent.attachReporter(extHtml);

			test = extent.createTest(clsName);

			orangeHrm = new OhrmBase();
			orangeHrm.OpenApplication("chrome");
			Reporter.log("Application opened");
			test.log(Status.PASS, "Application opened");

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to open Application");

		} finally {

			extent.flush();
		}
	}

	@Test
	public void Login() throws IOException {
		try {

			LoginPage loginPage = new LoginPage();

			loginPage.enterUserName("admin");
			loginPage.enterPassword("admin123");
			loginPage.clickLoginButton();

			welcomePage = new WelcomePage();

			// hard asserts : throws an assertion error when failed
			Assert.assertTrue(welcomePage.isDisplayed(), "isLoginsuccessful");
			
			//Assert.assertEquals(loginPage.getErrorText(), "Password cannot be empty");
			Reporter.log("Login is successful");
			test.log(Status.PASS, "Login is successful");
		} catch (NoSuchElementException e) {
			//test.addScreenCaptureFromPath(WebUtil.getScreen(), "Login Failure");
			MediaEntityModelProvider mediaModel = MediaEntityBuilder
					.createScreenCaptureFromBase64String(WebUtil.getScreen64()).build();
			
			//test.addScreenCaptureFromBase64String(WebUtil.getScreen64(), "LoginFailure");
			test.log(Status.FAIL, "Login Failed due to element identification",mediaModel);
			
			Assert.fail("Login Failed due to element identification");
		} catch (AssertionError a) {
			test.addScreenCaptureFromBase64String(WebUtil.getScreen64(), "LoginFailure");
			test.log(Status.FAIL, "Login Failed due to verification failure");
			Assert.fail("Login Failed due to verification failure");
		}
	}

	@Test(dependsOnMethods = "Login")
	public void AddEmployee() {
		try {
			welcomePage.clickOnPIM();
			welcomePage.clickOnAddEmployee();

			AddEmployeePage addEmployeePage = new AddEmployeePage();

			addEmployeePage.enterFirstName("selenium");
			addEmployeePage.enterLastName("hq");
			addEmployeePage.clickOnSaveButton();
			Reporter.log("Add Employee successful");
			test.log(Status.PASS, "Add Employee successful");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "AddEmployee Failed due to element identification");
			Assert.fail("AddEmployee Failed due to element identification");
		} catch (AssertionError a) {
			test.log(Status.FAIL, "AddEmployee Failed due to verification failure");
			Assert.fail("AddEmployee Failed due to verification failure");
		}
	}

	@AfterClass
	public void closeApplication() {
		orangeHrm.closeApplication();
		Reporter.log("Application Closed");
		test.log(Status.PASS, "Application Closed");

		extent.flush();
	}
}
