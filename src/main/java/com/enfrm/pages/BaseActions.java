package com.enfrm.pages;

import org.openqa.selenium.By;

public interface BaseActions {
	public String getName();
	public By getLocator();
	
	public default void click() {
		SeleniumWrapper.click(getLocator(),getName());
		System.out.println("clicked on "+getName());
	}
	public default void enterText(String val) {
		SeleniumWrapper.enterText(getLocator(), getName(),val);
		System.out.println(val+" entered on "+getName());
	}
}
