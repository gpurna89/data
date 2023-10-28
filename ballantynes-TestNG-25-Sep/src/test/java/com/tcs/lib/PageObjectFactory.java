package com.tcs.lib;

import com.tcs.pages.HeaderPage;
import com.tcs.pages.HomePage;
import com.tcs.pages.ItemPage;
import com.tcs.pages.LoginPage;

public class PageObjectFactory {

	private static HomePage homePage;
	private static HeaderPage headerPage;
	private static LoginPage loginPage;
	private static ItemPage itemPage;

	private PageObjectFactory() {
	}

	public static Page getPage(String page) {
		switch (page.toLowerCase().trim()) {
		case "homepage":
			return homePage == null ? homePage = new HomePage() : homePage;
		case "loginpage":
			return loginPage == null ? loginPage = new LoginPage() : loginPage;
		case "headerpage":
			return headerPage == null ? headerPage = new HeaderPage() : headerPage;
		case "itempage":
			return itemPage == null ? itemPage = new ItemPage() : itemPage;

		default:
			return null;
		}

	}

	public static void deleteAllObjects() {
		homePage = null;
		headerPage = null;
		loginPage = null;
	}

}
