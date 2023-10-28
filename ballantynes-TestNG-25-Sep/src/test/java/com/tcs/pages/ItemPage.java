package com.tcs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tcs.lib.Page;

public class ItemPage extends Page{

	public ItemPage() {
		PageFactory.initElements( getDriver(),this);
	}
	
	@FindBy(id="btnAddToCart")
	private WebElement btnAddToCart;
	
	public void clcikAddToCart() {
		jsClick(btnAddToCart);
	}

	@Override
	public Page getPage() {
		return null;
	}


}
