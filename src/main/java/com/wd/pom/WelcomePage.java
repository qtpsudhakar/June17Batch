package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends OhrmBase{

	
	private static By lnk_PIM = By.linkText("PIM");
	private static By lnk_AddEmployee = By.partialLinkText("Add Emp");
	
	private WebElement lnkPIM() {
		return getElement(lnk_PIM);
	}
	private WebElement lnkAddEmployee() {
		return getElement(lnk_AddEmployee);
	}
	
	public void clickOnPIM() {
		lnkPIM().click();
		System.out.println("Clicked on PIM link");
	}
	
	public void clickOnAddEmployee() {
		lnkAddEmployee().click();
		System.out.println("Clicked on Add Employee link");
	}
	
	public boolean isDisplayed() {
		
		return WebUtil.isElementExist(lnk_PIM);
	}
	
}
