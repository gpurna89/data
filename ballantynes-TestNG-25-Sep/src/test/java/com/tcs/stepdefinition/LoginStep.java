
package com.tcs.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.tcs.lib.PageObjectFactory;
import com.tcs.pages.HeaderPage;
import com.tcs.pages.HomePage;
import com.tcs.pages.LoginPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

	private HomePage homePage = ((HomePage) (PageObjectFactory.getPage("homepage")));
	private HeaderPage headerPage = ((HeaderPage) (PageObjectFactory.getPage("headerpage")));
	private LoginPage loginPage = ((LoginPage) (PageObjectFactory.getPage("loginpage")));

	@Given("a user is on the home page")
	public void aUserIsOnTheHomePage() {
		homePage.gotoHomePage();
		logger.info("User is on the home page");
		Assert.assertEquals(homePage.getTitle(),
				"Ballantynes Department Store | Home of designer fashion, luxury beauty & homewares - Ballantynes Department Store",
				"Home Page Title verification.");
	}

	@When("user clcik login link")
	public void userClcikLoginLink() {
		logger.info(headerPage.getTitle());
		logger.info("user clcik login link");
		logger.info(System.identityHashCode(headerPage));
		headerPage.clickLoginLink();
	}

	@Then("user should be navigated to login page")
	public void userShouldBeNavigatedToLoginPage() {
		logger.info("user should be navigated to login page");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Assert.assertEquals(loginPage.getTextOfHeader(), "Enter your login details",
				"Login page Header image verification.");
	}

	@Given("a user is on the login page")
	public void aUserIsOnTheLoginPage() {
		logger.info("a user is on the login page");
		Assert.assertTrue(loginPage.isLogingPage(),"Login page verification");
	}

	@When("user enter valid information \\(email, password) {string} {string}")
	public void userEnterValidInformationEmailPassword(String email, String pass) {
		logger.info("user enter valid information \\\\(email, password) {string} {string}\"");
		loginPage.enterCredential(email, pass);
	}

	@When("user click login button")
	public void userClickLoginButton() {
		logger.info("user click login button");
		loginPage.clickLoginBtn();
	}

	@Then("user should verify login successfully")
	public void userShouldVerifyLoginSuccessfully() {
		logger.info("user should verify login successfully");
			Assert.assertEquals(headerPage.getTextOfLogin(), "Sign Out","Verification of Login Success");
	}
	
	@Then("user should verify login unsuccessfully")
	public void userShouldVerifyLoginUnsuccessfully() {
		logger.info("user should verify login successfully");
		Assert.assertEquals(loginPage.getTextErrMsg(), "Invalid login - please check your details and retry.","Verification of Login Success");
	}

}
