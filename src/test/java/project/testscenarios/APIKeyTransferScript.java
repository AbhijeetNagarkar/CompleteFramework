package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class APIKeyTransferScript {
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AssetsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	@Test(priority = 50,groups = {"API Key Transfer"})
	public void NavigatingAssetPage() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnAPIKey();
		
		repo.dashboardPageObject().clickOnAPIKeyTransfer();
		
	}

	@Test(priority = 51,groups = {"API Key Transfer"},dependsOnMethods = "NavigatingAssetPage")
	public void APITransferActiveandExpiredCountPage() throws InterruptedException 
	{
		Assert.assertTrue(repo.APIKeyTransferPageObject().verifyCount(),"Active/Expired count not matching with records");
		
	}
	@Test(priority = 52,groups = {"API Key Transfer"},dependsOnMethods = "NavigatingAssetPage")
	public void ShareAPIKeyTransferFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.APIKeyTransferPageObject().shareAPIKey(),"Share Link with API Partner functionality not working");
		
	}

	
}
