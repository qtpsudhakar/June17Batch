package com.enfrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wd.util.DriverFactory;

public class OhrmAddEmpEnumDrive {
	
	public static void main(String[] args) {
		
		OhrmBase orangeHrm = new OhrmBase();
		orangeHrm.OpenApplication("chrome");
		
		LoginPage.txtUserName.enterText("admin");
		LoginPage.txtPassword.enterText("password");
		LoginPage.btnLogin.click();
		
	}
}









