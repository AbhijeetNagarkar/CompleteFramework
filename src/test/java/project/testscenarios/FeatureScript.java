package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class FeatureScript {
	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(FeatureScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	@Test(priority = 1,groups = {"Features"})
	public void NavigatingFeaturePage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnFeature();
		
		repo.dashboardPageObject().clickOnNewUpdates();
		
	}
	@Test(priority = 2,groups = {"Features"},dependsOnMethods = "NavigatingFeaturePage")
	public void FeaturePageVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.FeaturePageObject().verifyNewUpdates(),"Feature page verification failed");
	
	}
}
