package com.tcs.stepdefinition;

import com.tcs.lib.PageObjectFactory;
import com.tcs.pages.HeaderPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchStep {
	
	private HeaderPage headerPage =  (HeaderPage) PageObjectFactory.getPage("headerpage");

	@Given("user enter a item {string} in search box")
	public void userEnterAItemInSearchBox(String itemName) {
		headerPage.enterSearchTerm(itemName);
	}
	
	@When("user press enter key")
	public void userPressEnterKey() {
		headerPage.pressEnter();
	}
}
