package com.QA.Test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import com.QA.Base.BaseClass;

import com.QA.Pages.LoginPage;

public class HomeTest extends BaseClass{

	@BeforeClass()
	public void setup() throws IOException
	{
		Initializebrowser();
		
		
	}
}
