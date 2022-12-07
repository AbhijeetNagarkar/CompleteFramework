package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class AssetsScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AssetsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Assets"})
	public void NavigatingAssetPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnLocation();
		
		repo.dashboardPageObject().clickOnAssets();
		
	}

	@Test(priority = 2,groups = {"Assets"}, dependsOnMethods = "NavigatingAssetPage")
	public void ListViewOfAssets() throws InterruptedException 
	{
		Assert.assertTrue(repo.assetsPageObject().verifyCollapse(),"List view expand/collapse function not working");
		
	}
	@Test(priority = 3,groups = {"Assets"},dependsOnMethods = "NavigatingAssetPage")
	public void SearchAssets() throws InterruptedException 
	{
		Assert.assertTrue(repo.assetsPageObject().search(),"Unable to search on Assets Page");
		Assert.assertTrue(repo.assetsPageObject().verifyResult(),"Result not as per search criteria on Assets Page");

	}
	
	
}
