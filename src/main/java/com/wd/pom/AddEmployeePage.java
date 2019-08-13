package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class AddEmployeePage extends OhrmBase{

	private static By txt_FirstName = By.id("firstName");
	private static By txt_LastName = By.id("lastName");
	private static By btn_Save= By.xpath("//input[@value='Save']");
	
	private WebElement txtFirstName() {
		return getElement(txt_FirstName);
	}
	
	private WebElement txtLastName() {
		return getElement(txt_LastName);
	}
	
	private WebElement btnSave() {
		return getElement(btn_Save);
	}
	
	public void enterFirstName(String valToEnter) {
		txtFirstName().sendKeys(valToEnter);
		System.out.println(valToEnter+" entered on First Name");
		Reporter.log(valToEnter+" entered on First Name");
	}
	
	public void enterLastName(String valToEnter) {
		txtLastName().sendKeys(valToEnter);
		System.out.println(valToEnter+" entered on Last Name");
		Reporter.log(valToEnter+" entered on Last Name");
	}
	
	public void clickOnSaveButton() {
		btnSave().click();
		System.out.println("Clicked On Save Button");
		Reporter.log("Clicked On Save Button");
	}
}
