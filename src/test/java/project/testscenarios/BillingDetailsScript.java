package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class BillingDetailsScript {
	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AlertsScript.class);
	
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Billing Details"})
	public void NavigatingBillingDetailsPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnCompanyProfile();
		
		repo.dashboardPageObject().clickOnBillingDetails();
		
	}
	@Test(priority = 2,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void UpgradeFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().VerifyUpgradeFunctionality(),"Upgrade Functionality Not working");
		
	}
	@Test(priority = 3,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void AddMoreDeviceFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().VerifyAddMoreDevicesFunctionality(),"Add More Device Functionality Not working");
	}
	@Test(priority = 4,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void BuyAccessoriesFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().VerifyBuyAccessoriesFunctionality(),"Buy Accessories Functionality Not working");
	}
	@Test(priority = 5,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void NoOverduesFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().NoOverduesFunctionality(),"No Overdues Functionality Not working");
	}
	@Test(priority = 6,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void NextBillingFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().NextBillingFunctionality(),"Next Billing Functionality Not working");
	}
	@Test(priority = 7,groups = {"Billing Details"},dependsOnMethods = "NavigatingBillingDetailsPage" )
	public void HistoryFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.BillingDetailsPageObject().HistoryFunctionality(),"History Functionality Not working");
	}

}
