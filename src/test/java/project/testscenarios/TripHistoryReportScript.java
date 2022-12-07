package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TripHistoryReportScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(TripHistoryReportScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Trip History Reports"})
	public void NavigatingTripHistoryPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnTripHistory();
		
	}
	@Test(priority = 2,groups = {"Trip History Reports"},dependsOnMethods = "NavigatingTripHistoryPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.TripHistoryPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"Trip History Reports"},dependsOnMethods = "NavigatingTripHistoryPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.TripHistoryPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
	
	@Test(priority = 4,groups = {"Trip History Reports"},dependsOnMethods = "NavigatingTripHistoryPage" )
	public void DownloadFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.TripHistoryPageObject().VerifyDownload(),"Download functionality Not working");
	}
}
