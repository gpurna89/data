package com.tcs.pages;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.tcs.lib.Page;

public class HeaderPage extends Page {

	public HeaderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	@FindBy(css="input[title='Search']")
	private WebElement txtSearch;
	
	@FindBy(xpath = "//a[text()='Login / Register']")
	private WebElement linkLogin;

	@FindBy(xpath = "(//ul[@class='account-nav']//a)[last()]")
	private WebElement signOut;
	
	@FindBy(id="dropdownMenu1")
	private WebElement iconCart;
	

	public void clickLoginLink() {
		typeKey(KeyEvent.VK_ESCAPE);
		jsClick(getLinkLogin());
	}
	
	@Override
	public HeaderPage getPage() {
		return this;
	}

	public WebElement getLinkLogin() {
		return linkLogin;
	}

	public void enterSearchTerm(String serTerm) {
	    enterText(txtSearch,serTerm);
	}
	
	
	public String getTextOfLogin() {
	   waitUntilStaleness(getDriver().findElement(By.xpath("(//ul[@class='account-nav']//a)[last()]")));
		while (!getTextOfElement(getDriver().findElement(By.xpath("(//ul[@class='account-nav']//a)[last()]")))
				.equals("Sign Out")) {
		}
		signOut = getDriver().findElement(By.xpath("(//ul[@class='account-nav']//a)[last()]"));
		return getTextOfElement(signOut);
	}

	public void pressEnter() {
			typeKey(KeyEvent.VK_ENTER);
	}

	public void clcikCartIcon() {
		 jsClick(iconCart);
		
	}
}
