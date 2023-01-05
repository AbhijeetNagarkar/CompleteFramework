package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class FuelEfficiencyReportScript {
	
    WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(FuelEfficiencyReportScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Fuel Efficiency Reports"})
	public void NavigatingFuelEfficiencyPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnFuelEfficiency();
		
	}
	@Test(priority = 2,groups = {"Fuel Efficiency Reports"},dependsOnMethods = "NavigatingFuelEfficiencyPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.FuelEfficiencyPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	
	@Test(priority = 3,groups = {"Fuel Efficiency Reports"},dependsOnMethods = "NavigatingFuelEfficiencyPage" )
	public void DownloadFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.FuelEfficiencyPageObject().VerifyDownload(),"Download functionality Not working");
	}
	@Test(priority = 4,groups = {"Fuel Efficiency Reports"},dependsOnMethods = "NavigatingFuelEfficiencyPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.FuelEfficiencyPageObject().filterandverification(),"Records not showing as per filter criteria");
	}


	
}
