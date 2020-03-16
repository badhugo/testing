package com.PracticeNoOffice.Base;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.automation.baselayer.Log.Log;
import com.salesforce.automation.baselayer.WaitComponent.WaitComponent;
import com.salesforce.automation.servicelayer.Base.Base;
import com.salesforce.automation.servicelayer.config.SupportedPlatforms;
import com.salesforce.automation.servicelayer.utils.UrlUtilities;

/**
 * This class contains UI Utilities methods specific to project layer.
 * Created by ishriwastava on 6/13/17.
 */
public class UIUtilities {

	public static void switchWindows(WebDriver driver)
	{
		String scaWindowHandler = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles){
			if(!windowHandle.equals(scaWindowHandler))
				driver.switchTo().window(windowHandle);
		}
	}

	public static WebDriver waitForElementToLoadByXpath(WebDriver driver, final String xpathLocator){

		final FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)// check after every 5 seconds
				.ignoring(NoSuchElementException.class);// ignore NoSuchElementException

		Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>()
		{
			public Boolean apply(WebDriver driver) {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathLocator)));
				return true;		        
			}
		};

		wait.until(function);
		return driver;
	}

	public static void selectByVisibleText(WebElement element,String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}



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
				wait.until(ExpectedConditions.alertIsPresent());
				return true;		        
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


