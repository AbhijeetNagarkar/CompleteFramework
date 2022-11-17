package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DeletedDriverScript {
	
	WebPageObjectCreation repo;
	
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 43,groups = {"Drivers"})
	public void NavigatingDriversPage() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnDrivers();;
		
		repo.dashboardPageObject().clickOnDeletedDrivers();
	}
	
	@Test(priority = 44,groups = {"Drivers"},dependsOnMethods = "NavigatingDriversPage")
	public void SearchDriverFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.deletedDriversPageObject().search(),"Unable to search on Deleted Drivers Page");
	}
	@Test(priority = 45,groups = {"Drivers"},dependsOnMethods = "NavigatingDriversPage")
	public void DeletedDriversDetails() throws InterruptedException 
	{
		Assert.assertTrue(repo.deletedDriversPageObject().verifyResult(),"Search result not as per search criteria");
	}
	@Test(priority = 46,groups = {"Drivers"},dependsOnMethods = "NavigatingDriversPage")
	public void DeletedDriverLogBookFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.deletedDriversPageObject().verifyLogbook(),"unable to view logbook on Deleted Drivers Page");
	}
	
	
	

}
