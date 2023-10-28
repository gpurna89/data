package com.tcs.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions( tags = "@tag", dryRun = !true, features = {
		"/home/admin1/eclipse-workspace/ballantynes-TestNG-25-Sep/src/test/resources/feature/test.feature" }, 
glue = {"com.tcs.stepdefinition1" }, snippets = SnippetType.CAMELCASE, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/rerun.txt"})
public class TestRunner2 extends AbstractTestNGCucumberTests {}