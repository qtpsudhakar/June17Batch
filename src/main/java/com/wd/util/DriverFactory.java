package com.wd.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class DriverFactory {

	public static WebDriver getDriverFor(String brName) {

		WebDriver driver=null;
		switch (brName.toLowerCase()) {
		case "chrome":
			// specify browser driver exe file
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
			
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			
			// opens chrome browser
			driver = new ChromeDriver(co);

			break;

		case "firefox":
			// specify browser driver exe file
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");

			FirefoxProfile p = new FirefoxProfile();
			p.setPreference("dom.webnotifications.enabled", false);
			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(p);
			
			// opens firefox browser
			driver = new FirefoxDriver(fo);

			break;

		case "edge":
			// specify browser driver exe file
			System.setProperty("webdriver.edge.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\MicrosoftWebDriver.exe");

			// opens edge browser
			driver = new EdgeDriver();

			break;

		case "ie":
			// specify browser driver exe file
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\IEDriverServer.exe");

			// opens IE browser
			driver = new InternetExplorerDriver();

			break;

		default:
			// specify browser driver exe file
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");

			// opens chrome browser
			driver = new ChromeDriver();

			break;
		}
		
		return driver;

	}
}
