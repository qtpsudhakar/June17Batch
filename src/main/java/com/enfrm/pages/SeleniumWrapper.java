package com.enfrm.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class SeleniumWrapper extends OhrmBase {
	private static final Logger logger = Logger.getLogger(SeleniumWrapper.class);
	public static void click(By locator, String elmName) {
		try {
			getElement(locator).click();
			//System.out.println("clicked on "+elmName);
			logger.info("clicked on "+elmName);
		} catch (RuntimeException e) {
			//System.out.println("Failed to click on "+elmName);
			logger.error("Failed to click on"+elmName);
			throw e;
		}
	}
	
	public static void enterText(By locator,String elmName, String val) {
		try {
			getElement(locator).clear();
			getElement(locator).sendKeys(val);
			//System.out.println(val+" entered on "+elmName);
			logger.info(val+" entered on "+elmName);
		} catch (RuntimeException e) {
			//System.out.println("Failed to enter text on "+elmName);
			logger.info("Failed to enter text on "+elmName);
			throw e;
		}
	}
	
	public static boolean isElementExist(By locator) {
		
		try {
			getDriver().findElement(locator);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
