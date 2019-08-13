package com.pages;

import static com.report.ExtentTestManager.passStep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.base.OhrmBase;
import com.wd.core.SeleniumWrapper;

public class AddEmployeePage extends OhrmBase {

	private static By txt_FirstName = By.id("firstName");
	private static By txt_LastName = By.id("lastName");
	private static By btn_Save = By.xpath("//input[@value='Save']");

	public void enterFirstName(String valToEnter) {
		SeleniumWrapper.enterText(txt_FirstName, valToEnter);
		System.out.println(valToEnter + " entered on First Name");
		passStep(valToEnter + " entered on First Name");
	}

	public void enterLastName(String valToEnter) {
		SeleniumWrapper.enterText(txt_LastName, valToEnter);
		System.out.println(valToEnter + " entered on Last Name");
		passStep(valToEnter + " entered on Last Name");
	}

	public void clickOnSaveButton() {
		SeleniumWrapper.click(btn_Save);
		System.out.println("Clicked On Save Button");
		passStep("Clicked On Save Button");
	}
}
