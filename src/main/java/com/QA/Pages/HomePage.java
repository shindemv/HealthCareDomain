package com.QA.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[contains(text(),'Logged in as Super User)]") private WebElement heading;
	@FindBy(xpath="//a[contains(text(),'Logout')]")private WebElement logout;
	@FindBy(xpath="//a[contains(@id,'coreapps-activeVisitsHomepageLink-core')") private WebElement Find_patient_records;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-coreapps')]")private WebElement Active_Visit;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-vitals')") private WebElement capture_vitals;
	@FindBy(xpath="//a[contains(@id,'referenceapplication-registrationapp-registerPatient')]") private WebElement Register_patient;
	@FindBy(xpath="//a[contains(@id,'appointmentschedulingui')]")private WebElement Appointment_Scheduling;
	@FindBy(xpath="//a(contains(@id,'reportingui-reports-homepagelink')]")private WebElement Reports;
	@FindBy(xpath="//a[contains(@id,'coreapps-datamanagement')]")private WebElement Data_Management;
	@FindBy(xpath="//a[contains(@id,'org-openmrs-module-adminui']")private WebElement Configure_metadata;
	@FindBy(xpath="//a[contains(@id,'coreapps-systemadministration')]")private WebElement System_Administration;
	
	public void Logout() 
	{
		logout.click();
	}
	
	public void FindPatintRecord()
	{
		Find_patient_records.click();
	}
	
	public void ActiveVisit() 
	{
		Active_Visit.click();
	}
	
	public void CaptureVitals()
	{
		capture_vitals.click();
	}
	
	public void RegisterPatient()
	{
		Register_patient.click();
	}
	
	public void AoointmtntScheduling()
	{
		Appointment_Scheduling.click();
	}
	
	public void Reports()
	{
		Reports.click();
	}
	
	public void DataManagement()
	{
		Data_Management.click();
	}
	public void ConfigureMetadata()
	{
		Configure_metadata.click();
	}
	
	public void SystemAdministration() 
	{
		 System_Administration.click();
	}
}