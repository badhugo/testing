package com.nooffice.testingProjects;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Practice.NoOffice.Page.TablesPage;
import com.PracticeNoOffice.Base.Baseclass;

public class AlertDropdown extends Baseclass {
	
	


public AlertDropdown() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

@Test
public void copyingTableContentToExcel() throws IOException
{
	driver=Baseclass.getDriver();
	driver.navigate().to(URLTOExecute);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[contains(text(),'New Browser Window')]")).click();
	
	String scaWindowHandler1 = driver.getWindowHandle();
	Set<String> windowHandles1 = driver.getWindowHandles();
	for(String windowHandle:windowHandles1){
		if(!windowHandle.equals(scaWindowHandler1))
		{
			
			driver.switchTo().window(windowHandle);
		System.out.println(driver.getTitle());
		driver.close();
		}
	}
	driver.switchTo().window(scaWindowHandler1);

	driver.findElement(By.xpath("//*[contains(text(),'New Message Window')]")).click();
	String scaWindowHandler2 = driver.getWindowHandle();
	Set<String> windowHandles2 = driver.getWindowHandles();
	System.out.println(windowHandles2.size());
	
	for(String WindowMessage:windowHandles1)
	{
		if(!WindowMessage.equals(scaWindowHandler2))
		{
		driver.switchTo().window(WindowMessage);
		driver.close();
		
		}
		}
	
	
	
}
}

