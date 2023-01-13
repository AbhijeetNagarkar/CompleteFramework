package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class IdleTimeScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(IdleTimeScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Idle Time Report"})
	public void NavigatingIdleTimeReport() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnReports();  
		
		repo.dashboardPageObject().clickOnReportsSubMenu();
		
		repo.ReportsPageObject().ClickOnIdleTime();
		
		
	}
	
	@Test(priority = 2,groups = {"Idle Time Report"},dependsOnMethods = "NavigatingIdleTimeReport" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.IdleTimePageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"Idle Time Report"},dependsOnMethods = "NavigatingIdleTimeReport" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.IdleTimePageObject().filterandverification(),"Records not showing as per filter criteria");
	}
	

}
