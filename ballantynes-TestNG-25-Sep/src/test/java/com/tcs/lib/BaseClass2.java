package com.tcs.lib;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.tcs.stepdefinition.Hooks;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass2 {

	private static FluentWait<WebDriver> wait;
	private static WebDriver driver;
	
	
	protected void clickBtn(WebElement element) {
		waitUntilVisible(element).click();
	}
	protected void enterText(WebElement element,String value) {
		waitUntilVisible(element).sendKeys(value);
	}
	
	protected boolean isVisible(WebElement element) {
		return waitUntilVisible(element).isDisplayed();
	}
	
	
	protected String  getTextOfElement(WebElement element) {
		while(true)
		try {
		waitUntilVisible(element);
		break;
		}catch(Exception e) {}
	
			return waitUntilVisible(element).getText();
	}
	
	public void waitUntilStaleness(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	
	protected void  typeKey(int key) {
		try {
			Robot robot = new Robot();
			robot.keyPress(key);
			robot.keyRelease(key);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    private static final Logger logger = LogManager.getLogger(Hooks.class);

	private WebElement waitUntilVisible(WebElement element) {
		if(element==null)
			logger.info("****************************eemetnnumm**************");
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	protected void leftClick(WebElement element) {
		if(getDriver()!=null)
			waitUntilClickable(waitUntilVisible(element)).click();
	}
	
	
	protected void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click()",element);
	}
	
	private WebElement waitUntilClickable(WebElement ele) {
		
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	protected static WebDriver getDriver() {
		return   driver;// threadLocalDriver.get();
	}
	protected String getBase64Screenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	protected byte[] getBytesScreenshot() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
	}

	protected Boolean launchBrowser(String bName) {
		
		switch (bName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
	    //	System.setProperty("webdriver.chrome.logfile", "chromedriver.log");

	    	//options.setCapability("goog:loggingPrefs", "performance");
			driver = new ChromeDriver(options);
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			return false;
		}
		 wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
				 .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);			

		return true;
	}





	protected void gotoUrl(String url) {
		getDriver().get(url);
	}

	protected void maximizeBrowser() {
		getDriver().manage().window().maximize();
	}

	public String getTitle() {
		
		return getDriver().getTitle();
	}

	protected void quitBrowser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getDriver().quit();

        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());

	}
}
