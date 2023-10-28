package com.tcs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions( dryRun = !true,
features = { "/home/admin1/eclipse-workspace/ballantynes-TestNG-25-Sep/src/test/resources/feature" }, 
glue = {"com.tcs.stepdefinition" },
snippets = SnippetType.CAMELCASE,plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class TestRunner extends AbstractTestNGCucumberTests {
}
