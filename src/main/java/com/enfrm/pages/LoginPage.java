package com.enfrm.pages;

import org.openqa.selenium.By;

public enum LoginPage implements BaseActions{
	txtUserName(By.id("txtUsername")),
	txtPassword(By.id("txtPassword")), 
	btnLogin(By.id("btnLogin"));

	private By by;

	LoginPage(By by) {
		this.by = by;
	}

	public By getLocator() {
		return by;
	}

	public String getName() {
		return name();
	}
	
}

