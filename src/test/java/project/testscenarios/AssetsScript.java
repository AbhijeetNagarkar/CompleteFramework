package project.testscenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class AssetsScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AssetsScript.class);
	
	@Test(priority = 25,groups = {"Assets"})
	public void NavigatingAssetPage() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnLocation();
		
		repo.dashboardPageObject().clickOnAssets();
		
	}

	@Test(priority = 26,groups = {"Assets"}, dependsOnMethods = "NavigatingAssetPage")
	public void ListViewOfAssets() throws InterruptedException 
	{
		Assert.assertTrue(repo.assetsPageObject().verifyCollapse(),"List view expand/collapse function not working");
		
	}
	@Test(priority = 27,groups = {"Assets"},dependsOnMethods = "NavigatingAssetPage")
	public void SearchAssetsOnAssets() throws InterruptedException 
	{
		Assert.assertTrue(repo.assetsPageObject().search(),"Unable to search on Assets Page");
		
	}
	@Test(priority = 28,groups = {"Assets"},dependsOnMethods = "SearchAssetsOnAssets")
	public void AssetsAsPerSearch() throws InterruptedException 
	{
		Assert.assertTrue(repo.assetsPageObject().verifyResult(),"Result not as per search criteria on Assets Page");
		
	}
	
}
