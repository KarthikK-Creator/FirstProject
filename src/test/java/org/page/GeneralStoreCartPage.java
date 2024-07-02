package org.page;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreCartPage extends BaseClass{
	
	public GeneralStoreCartPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private WebElement afterPrice;

	public WebElement getAfterPrice() {
		return afterPrice;
	}
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement purchaseButton;
	
	public WebElement getPurchaseButton() {
		return purchaseButton;
	}
}