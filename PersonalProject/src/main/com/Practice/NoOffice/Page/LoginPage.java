package com.Practice.NoOffice.Page;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.PracticeNoOffice.Base.Baseclass;

import mx4j.log.Logger;

public class LoginPage extends Baseclass {

	
	
@FindBy(xpath="//label/following::input[@name='email' and @id='email']")
private static WebElement username;

@FindBy(xpath="//label/following::input[@name='passwd' and @id='passwd']")
private static WebElement password;

@FindBy(xpath="//*[@name='SubmitLogin' and @id='SubmitLogin']")
private static WebElement submit;


@FindBy(xpath="//a[contains(text(),'Sign out') and @title='Log me out']")
public static WebElement Logout;



public static WebElement getUsername()
{
	return username;
}

public static WebElement getPassword()
{
	return password;
}

public static WebElement getSubmit()
{
	return submit;
}

public static WebElement getLogout()
{
	return Logout;
}


public LoginPage() throws IOException
{
	super();
	PageFactory.initElements(driver,this);
	
}
public String login(WebDriver driver) throws InterruptedException
{
	String Title="";

	try
	{

	LoginPage.getUsername().sendKeys(AppUserName);
	LoginPage.getPassword().sendKeys(AppPassWord);
	LoginPage.getSubmit().click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Title=driver.getTitle();
	}
	catch(Exception e)
	{
e.printStackTrace();
}
	
	return Title;

}


public static String logoutPage(WebDriver driver) throws InterruptedException
{
	String Title="";

	try
	{
		LoginPage.getLogout().click();
	
	}
	catch(Exception e)
	{
e.printStackTrace();
}
	
	return Title;

}
}
