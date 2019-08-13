package com.tng.ohrm;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.pom.AddEmployeePage;
import com.wd.pom.LoginPage;
import com.wd.pom.OhrmBase;
import com.wd.pom.WelcomePage;

public class OhrmTestBase {
	OhrmBase orangeHrm;

	@BeforeClass
	public void openApplication() {
		orangeHrm = new OhrmBase();
		orangeHrm.OpenApplication("chrome");
	}

	@AfterClass
	public void closeApplication() {
		orangeHrm.closeApplication();
	}
}
