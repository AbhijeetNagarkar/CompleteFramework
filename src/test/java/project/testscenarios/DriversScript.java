package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DriversScript {
	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DriverSafetyScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Drivers"})
	public void NavigatingDriverPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnDrivers();
		
		repo.dashboardPageObject().clickOnDriversSubMenu();
		
		
		
	}
	@Test(priority = 2,groups = {"Drivers"})
	public void VerifyRecords() throws InterruptedException 
	{
			Assert.assertTrue(repo.DriversPageObject().verifyRecords(),"Records Not matching with active/inactive count");;
	}
	@Test(priority = 3,groups = {"Drivers"})
	public void SearchFunctionality() throws InterruptedException 
	{
			Assert.assertTrue(repo.DriversPageObject().searchDriver(),"Search functionality not working");
	}
	@Test(priority = 4,groups = {"Drivers"})
	public void CreateDriverFunctionality() throws InterruptedException 
	{
			Assert.assertTrue(repo.DriversPageObject().CreateDriver(),"Create Driver functionality not working");
	}
	
	

}
