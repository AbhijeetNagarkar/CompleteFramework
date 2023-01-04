package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.RandomVinAPI.RandomAPI;
import project.mediator.ObjectRepository;
import project.mediator.TestData;
import project.utility.WebPageObjectCreation;

public class DriversScript {
	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DriverSafetyScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
		
		GenerateMobileNumberforTest();
		
	}
	private void GenerateMobileNumberforTest() {

		String mobilenumber=RandomAPI.getMobileNumber();
		
		if(mobilenumber.equalsIgnoreCase(""))
			mobilenumber=RandomAPI.getMobileNumber();
		
		log.info("API Response for Random VIN : "+mobilenumber);
		
		TestData.GetDriversData().put("Cell",mobilenumber);
		TestData.GetDriversData().put("License","A"+mobilenumber);
		
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
	@Test(priority = 5,groups = {"Drivers"},dependsOnMethods = "CreateDriverFunctionality")
	public void EditDriverFunctionality() throws InterruptedException 
	{
			Assert.assertTrue(repo.DriversPageObject().EditDriver(),"Edit Driver functionality not working");
			Assert.assertTrue(repo.DriversPageObject().VerifyEditedDriver(),"Incorrect Driver details after Edit Operation");
	}
	@Test(priority = 6,groups = {"Drivers"},dependsOnMethods = "CreateDriverFunctionality")
	public void DeleteDriverFunctionality() throws InterruptedException 
	{
			Assert.assertTrue(repo.DriversPageObject().DeleteDriver(),"Delete Driver functionality not working");
			Assert.assertTrue(repo.DriversPageObject().verifyDeletedDriver(),"Deleted Driver not showing in Deleted Driver Page");
	}
	
	

}
