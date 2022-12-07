package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class UtilizationReportScript {
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(TripHistoryReportScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 50,groups = {"Utilization Report"})
	public void NavigatingUtilizationReportPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnUtilization();
		
	}
	@Test(priority = 51,groups = {"Utilization Report"},dependsOnMethods = "NavigatingUtilizationReportPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.UtilizationPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 52,groups = {"Utilization Report"},dependsOnMethods = "NavigatingUtilizationReportPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.UtilizationPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
	
	@Test(priority = 52,groups = {"Utilization Report"},dependsOnMethods = "NavigatingUtilizationReportPage" )
	public void DownloadFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.UtilizationPageObject().VerifyDownload(),"Download functionality Not working");
	}

}
