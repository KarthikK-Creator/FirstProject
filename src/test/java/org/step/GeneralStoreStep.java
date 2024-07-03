package org.step;

import java.net.MalformedURLException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.page.GeneralStoreCartPage;
import org.page.GeneralStoreHomePage;
import org.page.GeneralStoreLoginPage;

import io.cucumber.java.en.*;

public class GeneralStoreStep {
	BaseClass base = new BaseClass();
	GeneralStoreLoginPage loginPage;
	GeneralStoreHomePage homePage;
	GeneralStoreCartPage cartPage;
	String beforePrice, afterPrice;

	@Given("User launch the general store application")
	public void user_launch_the_general_store_application() throws MalformedURLException {
		base.launchApplication("Pixel8Pro",
				"C:\\Users\\hp\\eclipse-workspace\\GeneralStoreApplication\\src\\test\\resources\\Applications\\General-Store.apk");
	}

	@When("User clicks on the select country dropdown")
	public void user_clicks_on_the_select_country_dropdown() {
		loginPage = new GeneralStoreLoginPage();
		WebElement selectCountry = loginPage.getSelectCountry();
		base.mouseClick(selectCountry);
	}

	@When("User scrolls upto India")
	public void user_scrolls_upto_india() {
		base.scrollItem("India");
	}

	@When("User selects India")
	public void user_selects_india() {
		loginPage = new GeneralStoreLoginPage();
		WebElement selectIndia = loginPage.getSelectIndia();
		base.mouseClick(selectIndia);
	}

	@When("User enters name in Textbox")
	public void user_enters_name_in_textbox() {
		loginPage = new GeneralStoreLoginPage();
		WebElement userName = loginPage.getUserName();
		base.sendText(userName, "Karthik");
	}

	@When("User clicks on the LetsShop button")
	public void user_clicks_on_the_lets_shop_button() {
		loginPage = new GeneralStoreLoginPage();
		WebElement letsShop = loginPage.getLetsShop();
		base.mouseClick(letsShop);
	}

	@When("User clicks on the Add To Cart button")
	public void user_clicks_on_the_add_to_cart_button() throws InterruptedException {
		homePage = new GeneralStoreHomePage();
		Thread.sleep(3000);
		WebElement addToCart = homePage.getAddToCart();
		base.mouseClick(addToCart);
		beforePrice = homePage.getBeforePrice().getText();

	}

	@When("User clicks on the Cart icon")
	public void user_clicks_on_the_cart_icon() throws InterruptedException {
		homePage = new GeneralStoreHomePage();
		Thread.sleep(3000);
		WebElement cartButton = homePage.getCartButton();
		base.mouseClick(cartButton);
	}

	@When("User clicks on the CheckBox")
	public void user_clicks_on_the_check_box() {
		cartPage = new GeneralStoreCartPage();
		WebElement checkBox = cartPage.getCheckBox();
		base.mouseClick(checkBox);
	}

	@Then("User Validates the price of the product before and after adding to the cart")
	public void user_validates_the_price_of_the_product_before_and_after_adding_to_the_cart() {
		cartPage = new GeneralStoreCartPage();
		afterPrice = cartPage.getAfterPrice().getText();
		if (beforePrice.equals(afterPrice)) {
			System.out.println("Before and After Price is same");
		} else {
			System.out.println("Before and After Price is different");
		}
	}

	@When("User clicks Visit to the website to complete purchase button")
	public void user_clicks_visit_to_the_website_to_complete_purchase_button() throws InterruptedException {
		cartPage = new GeneralStoreCartPage();
		Thread.sleep(3000);
		WebElement purchaseButton = cartPage.getPurchaseButton();
		base.mouseClick(purchaseButton);
	}

	@When("User clicks back and close the application")
	public void user_clicks_back_and_close_the_application() throws InterruptedException {
		Thread.sleep(3000);
		base.keyActions("BACK");
		System.out.println("Developer");
		System.out.println("Tester Code");
		Thread.sleep(3000);
		base.endAll();

	}
}
