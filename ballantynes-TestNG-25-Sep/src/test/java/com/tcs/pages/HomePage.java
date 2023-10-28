package com.tcs.pages;

import com.tcs.lib.Page;

public class HomePage extends Page{

	public boolean gotoHomePage() {
		gotoUrl("https://www.ballantynes.co.nz");
		return true;
	}

	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public HomePage getPage() {
		return this;
	}
	
}
