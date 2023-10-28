package com.tcs.stepdefinition;

import com.tcs.lib.PageObjectFactory;
import com.tcs.pages.HeaderPage;
import com.tcs.pages.ItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStep {
	
	private ItemPage itemPage = (ItemPage) PageObjectFactory.getPage("itemPage");
	private HeaderPage headerPage = (HeaderPage) PageObjectFactory.getPage("headerPage");
	@Then("user click addtocart button")
	public void userClickAddtocartButton() {
		itemPage.clcikAddToCart();
		itemPage.clcikAddToCart();

	}
	
	
	@When("user click cart icon")
	public void userClickCartIcon() {
		headerPage.clcikCartIcon();
	}
	@When("user remove all items from  cart")
	public void userRemoveAllItemsFromCart() {
		
	}
	@Then("user should verify the message {string}")
	public void userShouldVerifyTheMessage(String string) {
	  
	}

}
