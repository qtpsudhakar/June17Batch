package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.base.OhrmBase;
import com.report.ExtentTestManager;
import static com.report.ExtentTestManager.passStep;
import com.util.WebUtil;
import com.wd.core.SeleniumWrapper;

public class LoginPage extends OhrmBase {

	private static By Txt_UserName = By.id("txtUsername");
	private static By Txt_Password = By.name("txtPassword");
	private static By Btn_Login = By.id("btnLogin");
	private static By elm_ErrorMsg = By.id("spanMessage");

	public void enterUserName(String valueToEnter) {
		SeleniumWrapper.enterText(Txt_UserName, valueToEnter);
		System.out.println(valueToEnter + " entered on UserName Text Box");
		passStep(valueToEnter + " entered on UserName Text Box");
	}

	public void enterPassword(String valueToEnter) {
		SeleniumWrapper.enterText(Txt_Password, valueToEnter);
		System.out.println(valueToEnter + " entered on Password Text Box");
		passStep(valueToEnter + " entered on Password Text Box");
	}

	public void clickLoginButton() {
		SeleniumWrapper.click(Btn_Login);
		System.out.println("Clicked on Login Button");
		passStep("Clicked on Login Button");
	}

	public boolean isUserNameDisplayed() {

		return SeleniumWrapper.isElementExist(Txt_UserName);

	}

	public boolean isPasswordDisplayed() {

		return SeleniumWrapper.isElementExist(Txt_Password);

	}

	public boolean isLoginButtonDisplayed() {

		return SeleniumWrapper.isElementExist(Btn_Login);

	}

	public String getErrorText() {
		return getElement(elm_ErrorMsg).getText();
	}
}
