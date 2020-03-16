package com.nooffice.testingProjects;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.PracticeNoOffice.Base.Baseclass;

public class randomPageUpload extends Baseclass {

	public randomPageUpload() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Test
	public void practicingPageUpload() throws IOException
	{
		driver=Baseclass.getDriver();
		driver.navigate().to(URLTOExecute);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	String fileLocation = System.getProperty("user.dir") + "\\src\\test\\resources" + "TestingNonOfficial.docx";
	  StringSelection filepath = new StringSelection(fileLocation);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	driver.findElement(By.xpath("//input[@type='file']")).click();
	try
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		   r.keyRelease(KeyEvent.VK_V);
		   r.keyRelease(KeyEvent.VK_CONTROL);
		   r.keyPress(KeyEvent.VK_ENTER);
		   r.keyRelease(KeyEvent.VK_ENTER);

		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		
		

	}
}
