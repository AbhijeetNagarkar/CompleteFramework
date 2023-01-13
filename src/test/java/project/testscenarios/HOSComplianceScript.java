package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class HOSComplianceScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(HOSComplianceScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"HOS Compliance Report"})
	public void NavigatingHOSComplianceReport() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();  
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnHOSCompliance();
		
		
	}
	
	@Test(priority = 2,groups = {"HOS Compliance Report"},dependsOnMethods = "NavigatingHOSComplianceReport" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.HOSCompliancePageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"HOS Compliance Report"},dependsOnMethods = "NavigatingHOSComplianceReport" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.HOSCompliancePageObject().filterandverification(),"Records not showing as per filter criteria");
	}

	

}
