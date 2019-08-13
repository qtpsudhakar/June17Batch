package com.pagesteps;

import com.pages.LoginPage;

//Employee
public class AddEmployeeSteps extends LoginPage {

	public void login() {
		enterUserName("admin");
		enterPassword("admin123");
		clickLoginButton();		
	}
}
