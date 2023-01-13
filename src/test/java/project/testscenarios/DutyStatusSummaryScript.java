package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DutyStatusSummaryScript {
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DutyStatusSummaryScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Duty Status Summary Report"})
	public void NavigatingDutyStatusSummaryReport() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();  
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnDutyStatusSummary();
		
		
	}
	
	@Test(priority = 2,groups = {"Duty Status Summary Report"},dependsOnMethods = "NavigatingDutyStatusSummaryReport" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.DutyStatusSummaryPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	

	@Test(priority = 3,groups = {"Duty Status Summary Report"},dependsOnMethods = "NavigatingDutyStatusSummaryReport" )
	public void DownloadFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.DutyStatusSummaryPageObject().VerifyDownload(),"Download functionality Not working");
	}

	/*@Test(priority = 4,groups = {"Duty Status Summary Report"},dependsOnMethods = "NavigatingDutyStatusSummaryReport" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.DutyStatusSummaryPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
	*/
}
