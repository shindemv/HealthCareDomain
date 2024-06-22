package com.QA.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.QA.Base.BaseClass;
import com.QA.Pages.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage login;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void prerequisite()
	{
		Initializebrowser();
		login=new LoginPage(driver);
	}
	
	@Test(priority=2)
	public void SuccessfullLogin() {
		login.username(property.getProperty("UserIdOpenMRS"));
		login.password(property.getProperty("PasswordOpenMRS"));
		login.Login_button();
		String Title=login.getTitle();
		System.out.println(Title);
	}
	@Test(priority=1)
	public void Invalid_UsernamePassword()
	{
		login.username("abcdef");
		login.password("pqrst");
		login.SelectOption("Inpatient Ward");
		login.Login_button();
		String Title = login.getTitle();
		System.out.println(Title);
	}
	
}
