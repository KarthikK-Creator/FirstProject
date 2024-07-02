package org.page;


import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreLoginPage extends BaseClass{
	
	// Constructor calling
	public GeneralStoreLoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Select Country Element
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountry;
	
	public WebElement getSelectCountry() {
		return selectCountry;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]")
	private WebElement selectIndia;
	
	public WebElement getSelectIndia() {
		return selectIndia;
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement userName;
	
	public WebElement getUserName() {
		return userName;
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShop;
	
	public WebElement getLetsShop() {
		return letsShop;
	}
	
}



