package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ELDLogbookEditsScript {
	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(ELDLogbookEditsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"ELD Logbook Edit Reports"})
	public void NavigatingELDLogbookEditReportsPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnELDLogbookEdits();
		
	}
	@Test(priority = 2,groups = {"ELD Logbook Edit Reports"},dependsOnMethods = "NavigatingELDLogbookEditReportsPage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.ELDLogbookEditsPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"ELD Logbook Edit Reports"},dependsOnMethods = "NavigatingELDLogbookEditReportsPage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.ELDLogbookEditsPageObject().filterandverification(),"Records not showing as per filter criteria");
	}

}
