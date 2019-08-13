package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.wd.core.SeleniumWrapper;

public class LoginPage extends OhrmBase {

	private static By Txt_UserName = By.id("txtUsername");
	private static By Txt_Password = By.name("txtPassword");
	private static By Btn_Login = By.id("btnLogin");
	private static By elm_ErrorMsg = By.id("spanMessage");
	
	private WebElement txtUserName() {
		return getDriver().findElement(Txt_UserName);
	}

	private WebElement txtPassword() {
		return getDriver().findElement(Txt_Password);
	}

	private WebElement btnLogin() {
		return getDriver().findElement(Btn_Login);
	}

	public void enterUserName(String valueToEnter) {
		getElement(Txt_UserName).clear();
		getElement(Txt_UserName).sendKeys(valueToEnter);
		System.out.println(valueToEnter + " entered on UserName Text Box");
		Reporter.log(valueToEnter + " entered on UserName Text Box");
	}

	public void enterPassword(String valueToEnter) {
		txtPassword().clear();
		txtPassword().sendKeys(valueToEnter);
		System.out.println(valueToEnter + " entered on Password Text Box");
		Reporter.log(valueToEnter + " entered on Password Text Box");
	}

	public void clickLoginButton() {
		SeleniumWrapper.click(Btn_Login);
		//btnLogin().click();
		System.out.println("Clicked on Login Button");
		Reporter.log("Clicked on Login Button");
	}

	public boolean isUserNameDisplayed() {

		return WebUtil.isElementExist(Txt_UserName);

	}
	
	public boolean isPasswordDisplayed() {

		return WebUtil.isElementExist(Txt_Password);

	}
	public boolean isLoginButtonDisplayed() {

		return WebUtil.isElementExist(Btn_Login);

	}
	
	public String getErrorText() {
		return getElement(elm_ErrorMsg).getText();
	}
}
