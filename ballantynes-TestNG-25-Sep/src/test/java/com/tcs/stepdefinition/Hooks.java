package com.tcs.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.service.ExtentService;
import com.tcs.lib.BaseClass;
import com.tcs.lib.PageObjectFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public void setUp() {
		ExtentService.getInstance().setSystemInfo("Selenium Version", "2.46");
		if (launchBrowser("chrome")) {
			PageObjectFactory.deleteAllObjects();
			System.out.println("launch Browser");
			logger.info("Before Hook: Browser Launching..........");
			maximizeBrowser();
		} else {
			Assert.assertTrue(false, "Browser launching : ");
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		scenario.attach(getBytesScreenshot(), "image/png", scenario.getName());
		quitBrowser();
		System.out.println("Quit Browser......");
		logger.info("After Hook: Browser Quit..........");

	}
}
