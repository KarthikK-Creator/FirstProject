Feature: Validate General Store Application
	
		Scenario: Validate the cart functionality
			Given User launch the general store application
			When User clicks on the select country dropdown
			And User scrolls upto India
			And User selects India
			When User enters name in Textbox
			When User clicks on the LetsShop button
			When User clicks on the Add To Cart button
			When User clicks on the Cart icon
			When User clicks on the CheckBox
			Then User Validates the price of the product before and after adding to the cart
			When User clicks Visit to the website to complete purchase button
			And User clicks back and close the application 