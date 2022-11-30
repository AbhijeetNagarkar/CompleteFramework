package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class IFTAReportScript {
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(IFTAReportScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 50,groups = {"IFTA"})
	public void NavigatingIFTAReportPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnIFTA();
		
		repo.dashboardPageObject().clickOnIFTAReports();
		
	}
	@Test(priority = 51,groups = {"IFTA"},dependsOnMethods = "NavigatingIFTAReportPage" )
	public void SearchOnIFTAReport() throws InterruptedException 
	{
		Assert.assertTrue(repo.IFTAReportsPageObject().SearchandVerifyRecords(),"Search functionality not working");
		
		Assert.assertTrue(repo.IFTAReportsPageObject().ActiveandDeletedTrucks(),"Active and Deleted Trucks not showing - caught error");;
		
		Assert.assertTrue(repo.IFTAReportsPageObject().VerifyDownloadReport(), "IFTA Report download functionality not working");
	}

}
