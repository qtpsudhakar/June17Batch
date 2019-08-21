package com.wd.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class C6SauceLabs {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		//https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
		String sauceUserName = "qtpsudhakar2";
        String sauceAccessKey = "5cba4c2e-875f-4fbb-b7f4-7af110e7ce3d";
        String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";        
		
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.13.0");
        caps.setCapability("deviceName","Android GoogleAPI Emulator");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("platformName","Android");
        
		AppiumDriver driver = new AndroidDriver(new URL(sauceURL), caps);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://apsrtconline.in");

		driver.findElement(By.id("fromPlaceName")).sendKeys("hyderabad");
		driver.findElement(By.linkText("HYDERABAD")).click();
		
		driver.findElement(By.id("toPlaceName")).sendKeys("vijayawada");
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText("VIJAYAWADA"))).click();
		//driver.findElement(By.linkText("VIJAYAWADA")).click();
		
		driver.hideKeyboard();
		driver.findElement(By.id("txtJourneyDate")).click();
		driver.findElement(By.linkText("30")).click();
		driver.findElement(By.id("searchBtn")).click();
		
	}

}








