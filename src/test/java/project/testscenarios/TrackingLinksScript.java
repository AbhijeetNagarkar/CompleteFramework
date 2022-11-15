package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TrackingLinksScript {
	
	WebPageObjectCreation repo;
		
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 29,groups = {"Tracking Links"})
	public void NavigatingTrackingLinksPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnLocation();
		
		repo.dashboardPageObject().clickOnTrackingLinks();
	}
	
	@Test(priority = 30,groups = {"Tracking Links"},dependsOnMethods = "NavigatingTrackingLinksPage")
	public void SearchTrackingLinks() throws InterruptedException 
	{
		Assert.assertTrue(repo.trackinglinksPageObject().search(), "Unable to search on Tracking Links Page");
	}
	
	@Test(priority = 31,groups = {"Tracking Links"},dependsOnMethods = "SearchTrackingLinks")
	public void RecordsOnTrackingLinks() throws InterruptedException 
	{
		Assert.assertTrue(repo.trackinglinksPageObject().verifyResult(), "Results not as per search Criteria");
	}
	

}
