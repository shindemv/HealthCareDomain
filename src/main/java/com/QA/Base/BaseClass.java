package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties property;// properties is class
	public static WebDriver driver; // webdriver is interface
	public static ChromeOptions option; // chromeoptions is class to use for handle notification
	
	public BaseClass()
	{
		System.out.println(System.getProperty("user.dir"));// user directory (user.dir) to control the project
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\Properties\\config.properties";
		
		System.out.println("file path is : "+path);
		try {
			FileInputStream file = new FileInputStream(path);
			property=new Properties();
			property.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void Initializebrowser() {
		
		String browsername=property.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			option=new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();;
			driver=new EdgeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(property.getProperty("OpenMRS"));
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		
	}
}
