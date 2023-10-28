package com.tcs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tcs.lib.Page;

public class LoginPage extends  Page{
	
	public LoginPage() {
			PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath = "//button[@class='close']//following-sibling::*")
	private WebElement txtLoginHeader;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogin;
	@FindBy(id="EmailAddress")
	private WebElement txtEmail;
	
	@FindBy(id="Password")
	private WebElement txtPass;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors alert alert-danger']/ul/li")
	private WebElement txtErr;
	
	public void enterEmail(String email) {
		enterText(txtEmail,email);
	}
	
	public void enterPass(String pass) {
		enterText(txtPass,pass);
	}
	
	public String getTextOfHeader() {
		while(!getTextOfElement(txtLoginHeader).equals("Enter your login details")) {}
		 return  getTextOfElement(txtLoginHeader);
	}

	public void enterCredential(String email, String pass) {
		enterEmail(email);
		enterPass(pass);
	}

	
	@Override
	public LoginPage getPage() {
		return this;
	}

	public boolean isLogingPage() {
		return isVisible(btnLogin);
	}
	
	public void clickLoginBtn() {
		clickBtn(btnLogin);
	}

	public String getTextErrMsg() {
		return getTextOfElement(txtErr);
	}

}
