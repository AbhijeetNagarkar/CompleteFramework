package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class PostTripDVIRReportScript {

WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(PreTripDVIRReportScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Post Trip DVIR Reports"})
	public void NavigatingPostTripDVIRPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnPostTripDVIR();
		
	}
	@Test(priority = 2,groups = {"Post Trip DVIR Reports"},dependsOnMethods = "NavigatingPostTripDVIRPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.PostTripPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"Post Trip DVIR Reports"},dependsOnMethods = "NavigatingPostTripDVIRPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.PostTripPageObject().filterandverification(),"Records not showing as per filter criteria");
	}
}
