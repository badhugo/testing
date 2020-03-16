package com.Practice.NoOffice.Page;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.PracticeNoOffice.Base.Baseclass;

public class CasualDresses extends Baseclass{
	

@FindBy(xpath="//ul//li[@id='category-thumbnail']//following::a[contains(text(),'Dresses') and @title='Dresses']")
private static WebElement Dresses;

@FindBy(xpath="//label/following::input[@name='passwd' and @id='passwd']")
private static WebElement CasualDressses;

@FindBy(xpath="//select[@id='selectProductSort']")
private static WebElement sortBy;




public static WebElement getDresses()
{
	return Dresses;
}

public static WebElement getCasualDressses()
{
	return CasualDressses;
}

public static WebElement getsortBy()
{
	return sortBy;
}



public CasualDresses() throws IOException
{
	super();
	PageFactory.initElements(driver,this);
	
}


public static void sorting(WebDriver driver)
{
	try
	{
	CasualDresses.getDresses().click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Select sc=new Select(CasualDresses.getsortBy());
	List<WebElement> li=sc.getOptions();
	
	for(int i=0;i<li.size();i++)
	{
		System.out.println(li.get(i).getText());
		}
sc.selectByVisibleText("In stock");
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}

}
