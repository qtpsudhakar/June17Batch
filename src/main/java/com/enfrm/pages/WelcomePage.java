package com.enfrm.pages;

import org.openqa.selenium.By;

public enum WelcomePage implements BaseActions{

	lnkPIM(By.linkText("PIM")),
	lnkAddEmployee(By.partialLinkText("Add Emp"));
	
	private By by;

	WelcomePage(By by) {
		this.by = by;
	}

	public By getLocator() {
		return by;
	}

	public String getName() {
		return name();
	}
	
}

