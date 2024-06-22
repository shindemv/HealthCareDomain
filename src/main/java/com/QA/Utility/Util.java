package com.QA.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Base.BaseClass;

public class Util extends BaseClass{
	
	public static void  WaitforElement(WebElement element)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void ElementTobeClickable(WebElement element)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void WaitforElements(List<WebElement> element)
	{
		WebDriverWait webdriverwait = new WebDriverWait(driver,Duration.ofSeconds(15));
		webdriverwait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static void click(WebElement element)
	{
		element.click();
	}
	
	public static void sendkeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public static Object[][] getTestData(String Sheetname)
	{
		FileInputStream file = null;
		Workbook book = null;
		try {
			file=new FileInputStream();
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			book=WorkbookFactory.create(file);
		}
		catch(EncryptedDocumentException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		Sheet sh=book.getSheet(Sheetname);
		Object [][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sh.getLastRowNum(); i++)
		{
			for (int j=0; j<sh.getRow(0).getLastCellNum(); j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	
	}
	
	public static void MovetoElement(WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public static void ClickAndHold(WebElement element)
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
}
