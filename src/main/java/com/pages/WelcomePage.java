package com.pages;

import static com.report.ExtentTestManager.passStep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.OhrmBase;
import com.util.WebUtil;
import com.wd.core.SeleniumWrapper;

public class WelcomePage extends OhrmBase{

	
	private static By lnk_PIM = By.linkText("PIM");
	private static By lnk_AddEmployee = By.partialLinkText("Add Emp");
	
	
	public void clickOnPIM() {
		SeleniumWrapper.click(lnk_PIM);
		System.out.println("Clicked on PIM link");
		passStep("Clicked on PIM link");
	}
	
	public void clickOnAddEmployee() {
		SeleniumWrapper.click(lnk_AddEmployee);
		System.out.println("Clicked on Add Employee link");
		passStep("Clicked on Add Employee link");
	}
	
	public boolean isDisplayed() {
		
		return SeleniumWrapper.isElementExist(lnk_PIM);
	}
	
}
