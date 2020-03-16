package com.PracticeNoOffice.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	
	
	public static Hashtable<String,String> credentials=new Hashtable<String, String>();
	
	public static  String AppUserName="";
	public static  String AppPassWord="";
	public static  String TestingURL="";
	public static String TableURL="";
	public static String AlertsURl="";
	public static String PageUploadURL="";
	private final String vendorEnv="app.Properties";
	private final FileInputStream FileInputStreamTest;
	public Properties VendorProperties;
	public String Platform;
	public static String URLTOExecute="";
	public static WebDriver driver;
	
	
	
	@BeforeMethod
	public void beforeloadingmethods()
	{
		
 if(Platform.equals("testing"))
 {
	 URLTOExecute=TestingURL;
 }else if(Platform.equals("tables"))
 {
	 URLTOExecute=TableURL;
 }else if(Platform.equals("alert"))
 {
	 URLTOExecute=AlertsURl;

 }else
 {
	 URLTOExecute=PageUploadURL;

 }
		
	}
	public Baseclass() throws IOException
	{
		

		
		AppUserName=Baseclass.loginCredentials().get("UserName");
		AppPassWord=Baseclass.credentials.get("password");
		TestingURL=Baseclass.credentials.get("URL");
		TableURL=Baseclass.credentials.get("URLForTables");
		AlertsURl=Baseclass.credentials.get("URLForAlerts");
		PageUploadURL=Baseclass.credentials.get("URLForUpload");
		FileInputStreamTest=new FileInputStream("C:\\Users\\bharadwajg\\Desktop\\sfdc_pse\\PersonalProject\\src\\test\\resources\\app.Properties");
		VendorProperties =new Properties();
		if(FileInputStreamTest!=null)
		{
			VendorProperties.load(FileInputStreamTest);
			Platform=VendorProperties.getProperty("purpose");
			
			
			
		}


	}
	
	
	
	public static Hashtable<String,String> loginCredentials()
	{
		
		credentials.put("UserName", "bharadwajgodavarthit@gmail.com");
		credentials.put("password", "Saradhigvs@123");
		credentials.put("URL", "http://automationpractice.com/index.php?controller=authentication&back=my-account");
		credentials.put("URLForTables", "https://www.techlistic.com/p/demo-selenium-practice.html");
		credentials.put("URLForAlerts","http://www.seleniumframework.com/Practiceform/");
		credentials.put("URLForUpload","http://webdriveruniversity.com/File-Upload/index.html");

		return credentials;
		
	}
	
	public static WebDriver getDriver()
	{
		
		
		DesiredCapabilities ds=new DesiredCapabilities().chrome();
		ChromeOptions cs=new ChromeOptions();
		cs.addArguments("incognito");
		ds.setCapability(ChromeOptions.CAPABILITY, cs);
		ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bharadwajg\\Downloads\\chromedriver_win32_version78\\chromedriver.exe");

		  driver=new ChromeDriver(cs);
		 driver.manage().window().maximize();
		return driver;
	}
	
	@AfterMethod
public void teardown() throws IOException
{
		
		
File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(src, new File("C:\\Users\\bharadwajg\\Downloads\\testJavaProject\\image.png"));
driver.quit();
}

}
