package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.OhrmConfig;
import com.wd.util.DriverFactory;

public class OhrmBase extends DriverFactory{
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ThreadLocal<WebDriverWait> wait= new ThreadLocal<WebDriverWait>();
	
	
	public void OpenApplication(String brName) {
		// opens browser
		driver.set(getDriverFor(brName));
		//driver = getDriverFor(brName);

		// page navigation timeout
		driver.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		// element waiting timeout
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigates to orangehrm
		driver.get().get(OhrmConfig.APP_URL);
		System.out.println("Application is Opened");
		
		wait.set(new WebDriverWait(driver.get(), 20));
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static WebDriverWait getWait() {
		return wait.get();
	}
	public void closeApplication() {
		driver.get().quit();
		System.out.println("Application is Closed");
	}
	
	public static WebElement getElement(By locator) {
		wait.get().until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.get().findElement(locator);
	}
}
