package com.PracticeNoOffice.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Practice.NoOffice.Page.CasualDresses;
import com.Practice.NoOffice.Page.LoginPage;
import com.PracticeNoOffice.Base.Baseclass;

import jline.internal.Log;
import mx4j.log.Logger;

public class testingProject extends Baseclass{
	
	public testingProject() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static WebDriver driver=null;

	@Test(enabled=false)
	public void SimpleLogin() throws InterruptedException, IOException
	{
	   driver=Baseclass.getDriver();
	   driver.navigate().to(URLTOExecute);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   LoginPage Login1=new LoginPage();
	   Log.info("Login to webpage");
	   String Title=Login1.login(driver);
	   Assert.assertEquals(Title, "My account - My Store");
	   LoginPage.logoutPage(driver);
	   
	}
	
	@Test(enabled=true)
	public void CausualDressesSorting() throws InterruptedException, IOException
	{
	   driver=Baseclass.getDriver();
	   driver.navigate().to(URLTOExecute);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   LoginPage Login1=new LoginPage();
	   String Title=Login1.login(driver);
	   Assert.assertEquals(Title, "My account - My Store");
	   CasualDresses cs=new CasualDresses();
	   cs.sorting(driver);
	   
	   LoginPage.logoutPage(driver);
	   
	}
	
	
	

}
