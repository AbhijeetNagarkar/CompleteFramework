package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DriverSafetyScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DriverSafetyScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Driver Safety Reports"})
	public void NavigatingDriverSafetyPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnDriverSafety();
		
	}
	@Test(priority = 2,groups = {"Driver Safety Reports"},dependsOnMethods = "NavigatingDriverSafetyPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.DriverSafetyPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"Driver Safety Reports"},dependsOnMethods = "NavigatingDriverSafetyPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.DriverSafetyPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
}
