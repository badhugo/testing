package com.PracticeNoOffice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private static FileInputStream fs;
	private static XSSFWorkbook wb;
	private static XSSFSheet sh;
	private static XSSFRow rw;
	private static XSSFCell ce;
	
	
	
	public ExcelReader() throws IOException
	{
		fs=new FileInputStream("C:\\Users\\bharadwajg\\Desktop\\sfdc_pse\\PersonalProject\\src\\test\\resources\\sampleProjectOwn.xlsx");
		if(fs!=null)
		{
			wb=new XSSFWorkbook(fs);
			
		}
	}

}
