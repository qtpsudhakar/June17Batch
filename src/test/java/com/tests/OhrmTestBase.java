package com.tests;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.OhrmBase;
import com.config.OhrmConfig;
import com.config.OpenBrowserFor;
import com.report.ExtentReportManager;
import com.report.ExtentTestManager;

public class OhrmTestBase extends OhrmBase {
	private String xmlTestName;

	@BeforeSuite
	public void createSuiteConfig() {
		// createSuiteReport
		ExtentReportManager.initExtentReporter("OrangeHRM");
	}

	@AfterSuite
	public void closeSuiteConfig(ITestContext tst) {
		// closeSuiteReport
		ExtentReportManager.getInstance().flush();
	}
	
	@BeforeClass
	@Parameters({ "browser" })
	public void createClassConfig(String brName, ITestContext tst) {
		ExtentTestManager.enableReporting();
		xmlTestName = tst.getName();
		// createClassReporter
		ExtentTestManager.setReporter(ExtentReportManager.getInstance(), OhrmConfig.SCREEN_SHOT_POLICY);
		ExtentTestManager.createTest(xmlTestName + ":" + this.getClass().getSimpleName());
		OpenApplication(brName);

	}

	@AfterClass
	public void closeClassConfig() {
		// closeClassReport
		ExtentReportManager.getInstance().flush();
		closeApplication();

	}

	@BeforeMethod
	public void createMethodConfig(Method method) {
		ExtentTestManager.enableReporting();
		// createTMReporter
		ExtentTestManager.setNodeTest(ExtentTestManager.getTest(getClass().getSimpleName()).createNode("TC ID: "
				+ method.getName() + " <br/> " + "TC Description: " + method.getAnnotation(Test.class).description()));
	}

	@AfterMethod
	public void closeMethodConfig(Method method, ITestResult result) {
		// closeTMReporter
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestManager.getNodeTest().fail(result.getThrowable().getMessage());
		}
		ExtentTestManager.removeNodeTest();
	}
}
