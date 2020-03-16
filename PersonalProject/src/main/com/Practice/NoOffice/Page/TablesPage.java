package com.Practice.NoOffice.Page;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.PracticeNoOffice.Base.Baseclass;

public class TablesPage extends Baseclass{
	

public TablesPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

public static void readTablevalues(WebDriver driver)
{
	try
	{
	List<WebElement> row=driver.findElements(By.xpath("//table[@summary='Sample Table']//tbody//tr"));
	List<WebElement> rowH=driver.findElements(By.xpath("//table[@summary='Sample Table']//thead//tr//th"));
	
	for(int a=1;a<=rowH.size();a++)
	{
		
		WebElement rowHH=driver.findElement(By.xpath("//table[@summary='Sample Table']//thead//tr//th["+a+"]"));
		System.out.println(rowHH.getText());

	}
	for(int i=1;i<=row.size();i++)
	{
		
		List<WebElement> col=driver.findElements(By.xpath("//table[@summary='Sample Table']//tbody//tr["+i+"]//th"));
		
		for(int j=1;j<=col.size();j++)
		{
			WebElement colValue=driver.findElement(By.xpath("//table[@summary='Sample Table']//tbody//tr["+i+"]//th["+j+"]"));
			System.out.println(colValue.getText());
			List<WebElement> c=driver.findElements(By.xpath("//table[@summary='Sample Table']//tbody//tr["+i+"]//th["+j+"]//following-sibling::td"));

			for(int k=1;k<=c.size();k++)
			{
				WebElement cc=driver.findElement(By.xpath("//table[@summary='Sample Table']//tbody//tr["+i+"]//th["+j+"]//following-sibling::td["+k+"]"));

				System.out.println(cc.getText());
			}

		}
	}
		
		}
	catch(Exception e)
	{}
	
}

}
