package com.wd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetailsPage extends OhrmBase{

	private static By btn_Edit = By.xpath("//input[@value=\"Edit\"]");
	private static By cmb_Country = By.id("personal_cmbNation");
	
	private WebElement btnEdit() {
		return getElement(btn_Edit);
	}
	
	private WebElement cmbCountry() {
		return getElement(cmb_Country);
	}
	
	public void clickOnEditButton() {
		btnEdit().click();
		System.out.println("Clicked on Edit Button");
	}
	
	public void selectCountry(String cName) {
		Select lstCountry = new Select(cmbCountry());
		lstCountry.selectByVisibleText(cName);
		System.out.println(cName+" is selected in country list");
	}
	//over loading
	public void selectCountry(int cIndex) {
		Select lstCountry = new Select(cmbCountry());
		lstCountry.selectByIndex(cIndex);
		System.out.println(cIndex+" indexed item is selected in country list");
	}
	
}