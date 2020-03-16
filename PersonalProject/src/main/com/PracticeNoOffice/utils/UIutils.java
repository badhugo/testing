package com.PracticeNoOffice.utils;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIutils {
	
	
	public static void switchWindows(WebDriver driver)
	{
		String scaWindowHandler = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles){
			if(!windowHandle.equals(scaWindowHandler))
				driver.switchTo().window(windowHandle);
		}
	}

	/**
	 * @author- ishriwastava
	 * @param webElement - webElement of a element on a page
	 * This method will wait for a WebElement to be present on the DOM of a page using Locator-Xpath.
	 */
	public static WebDriver waitForElementToLoadByXpath(WebDriver driver, final String xpathLocator){

		final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)// check after every 5 seconds
				.ignoring(NoSuchElementException.class);// ignore NoSuchElementException

		Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>()
		{
			public Boolean apply(WebDriver driver) {
				try{
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
					return true;
				}catch(TimeoutException e){
					System.out.println("Timed Out!!");
					return false;
				}		        
			}
		};

		wait.until(function);
		return driver;
	}

	public static void selectByVisibleText(WebElement element,String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/*public static String getIdFromUrl(String strURL){
		String [] split;
		if (Base.config.get("IS_PLATFORM")== "lightning")	
		{
			split = strURL.split("#/sObject/");
		}else
		{
			split = strURL.split(".salesforce.com/");
		}

		if(split[1].indexOf("/")>0){
			return split[1].split("/")[0];
		}
		else if (split[1].indexOf("#")>0){
			return split[1].split("#")[0];
		}

		return split[1];
	}*/


	/**
	 * Method to wait for an alert pop up to happen.
	 */
	public static WebDriver waitForAlertMsg(WebDriver driver){
		final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(120, TimeUnit.SECONDS) 
				.pollingEvery(5, TimeUnit.SECONDS)  // check after every 5 seconds
				.ignoring(NoSuchElementException.class);  // ignore NoSuchElementException

		Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>()
		{
			public Boolean apply(WebDriver driver) {
				try{
					wait.until(ExpectedConditions.alertIsPresent());
					return true;
				}catch(TimeoutException e){
					System.out.println("Timed Out!!");
					return false;
				}		        
			}
		};
		wait.until(function);		
		return driver;
	}

	public void selectByIndex(WebElement element,int index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}


	/** 
	 * This method will verify alert is present or not
	 * @return
	 */
	public boolean isAlertPresent(WebDriver driver) {    
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}





	/** 
	 * This method will verify web element  is visible or not
	 * @return
	 */
	public static boolean isElementVisible(WebDriver driver,String elementXpath) {
		try {
			driver.findElement(By.xpath(elementXpath));
			return true;

		}
		catch(NoSuchElementException e) {
			return false;
		}

	}

	/** 
	 * This method will wait till text present in WebElement
	 * @return
	 */
	public static void waitForVisibilityOfElementLocated(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	 

}
