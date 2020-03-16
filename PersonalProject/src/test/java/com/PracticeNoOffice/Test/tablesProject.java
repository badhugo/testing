package com.PracticeNoOffice.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.Practice.NoOffice.Page.TablesPage;
import com.PracticeNoOffice.Base.Baseclass;

public class tablesProject extends Baseclass {
	public tablesProject() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void copyingTableContentToExcel() throws IOException
	{
		driver=Baseclass.getDriver();
		driver.navigate().to(URLTOExecute);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TablesPage tb=new TablesPage();
		tb.readTablevalues(driver);
		
	}

	
}
