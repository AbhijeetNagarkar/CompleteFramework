package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ReportsScript {
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(ReportsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 50,groups = {"Reports"})
	public void Navigation() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnDriverSafety();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnDutyStatusSummary();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnELDLogbookEdits();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnFuelEfficiency();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnHOSCompliance();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnIdleTime();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnPostTripDVIR();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnPreTripDVIR();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnTemperatureHumidity();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnTripHistory();
		
		Driver.GetDriver().navigate().back();
		
		repo.ReportsPageObject().ClickOnUtilization();
		
		Driver.GetDriver().navigate().back();
		
		
	}
	@Test(priority = 51,groups = {"Reports"},dependsOnMethods = "Navigation" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.ReportsPageObject().search(),"Unable to search on Reports in Reports Dashboard");
	}


}
