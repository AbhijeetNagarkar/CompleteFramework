package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.RandomVinAPI.RandomAPI;
import project.mediator.ObjectRepository;
import project.mediator.TestData;
import project.utility.WebPageObjectCreation;

public class TrailerScript {

	WebPageObjectCreation repo;
	
	String vin;
	
	boolean flag;
	
	HashMap<String,String> vehiclemap,trailermap;
	
	public static Logger log = Logger.getLogger(TrailerScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority =1, groups = {"Trailers"})
	public void NavigatingTrailerPage() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
	//	Thread.sleep(5000);
	}
	
	
	@Test(priority = 2, dependsOnMethods = "NavigatingTrailerPage",groups = {"Trailers"} )
	public void NewTrailer() throws InterruptedException
	{
		
//		repo=ObjectRepository.GetInstance();
		
		vehiclemap=TestData.GetVehicleData();
		
		trailermap=TestData.GetTrailerData();
		
		repo.trailerPageObject().clickOnAddTrailerDashboard();
		
		log.info("Calling API to generate Random VIN");
		
		vin=RandomAPI.getVin();
		
		log.info("API Response for Random VIN : "+vin);
		
		trailermap.put("Trailer Identifier", vin);
		
		repo.trailerPageObject().EntertrailerIdentifier();
		
		repo.trailerPageObject().ClickOnSave();
		
		repo.trailerPageObject().ClickOnNo();
		
		repo.trailerPageObject().SearchTrailer();
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
		
	}
			
	@Test(priority = 3,dependsOnMethods = "NewTrailer",groups = {"Trailers"})
	public void AssignTrailer() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.trailerPageObject().SearchTrailer();
		
		repo.trailerPageObject().ClickOnAssign();
		
		repo.trailerPageObject().ClickOnTruckDropdown(); //
		
		repo.trailerPageObject().SelectTruckFromDropDown();
		
		repo.trailerPageObject().ClickOnUpdate();
		
		flag=repo.trailerPageObject().VerifyAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated after Assigned on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	
		
	@Test(priority = 4, dependsOnMethods = {"AssignTrailer"},groups = {"Trailers"} )
	public void UnAssignTrailer() throws InterruptedException
	{	
		repo.dashboardPageObject().refresh();
		
		repo.trailerPageObject().SearchTrailer();
		
		repo.trailerPageObject().ClickOnUnAssign();
		
		repo.trailerPageObject().ClickOnYes();
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated after UnAssigned on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	
	@Test(priority = 5, dependsOnMethods = "NewTrailer",groups = {"Trailers"} )
	public void EditTrailer() throws InterruptedException
	{
	
		repo.dashboardPageObject().refresh();
		
		repo.trailerPageObject().SearchTrailer();
		
		repo.trailerPageObject().EditTrailer();
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated after Edit on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	
	}
	@Test(priority = 6, dependsOnMethods = "NewTrailer",groups = {"Trailers"})
	public void DeleteTrailer() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.trailerPageObject().SearchTrailer();
		
		repo.trailerPageObject().DeleteTrailer();
		
		repo.trailerPageObject().SearchTrailer();
		
		flag=repo.trailerPageObject().VerifyDeletedTrailer();
		
		if(flag)
			log.info("Deleted Trailer Verified on Dashboard successfully");
		else 
			Assert.fail("Deleted Trailer showing on Trailer Dashboard");
	
			
	}
	@Test(priority = 7, dependsOnMethods = "DeleteTrailer",groups = {"Trailers"})
	public void NavigatingDeletedTrailerPage() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrailers();
		
		Thread.sleep(5000);
	}
	@Test(priority = 8, dependsOnMethods ="NavigatingDeletedTrailerPage",groups = {"Trailers"} )
	public void ActivateTrailer() throws InterruptedException
	{
		repo.trailerPageObject().ActivateTrailer();
		
		Thread.sleep(3000);
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		repo.trailerPageObject().changeFocus();
		
		repo.trailerPageObject().SearchTrailer();
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	
		
	@Test(priority = 9,groups = {"Trucks"})
	public void DeleteTruck() throws InterruptedException
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().refresh();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
		
		repo.truckPageObject().searchTruckonDashboard(); 
		
		repo.truckPageObject().DeleteTruck();
		
		Thread.sleep(3000);
		
		repo.truckPageObject().searchTruckonDashboard();
		
		flag=repo.truckPageObject().verifyDeletedTruckonDashboard();
		
		if(flag)
			Assert.fail("Deleted Truck showing as Active");
		else 
			log.info("Verified Deleted Truck on Dashboard");
	}
	@Test(priority = 10,groups = {"Trucks"})
	public void NavigatingDeletedTruckPage() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrucks();
		
		Thread.sleep(5000);
	}
	@Test(priority = 11, dependsOnMethods = "NavigatingDeletedTruckPage",groups = {"Trucks"})
	public void ActivateTruck() throws InterruptedException
	{
		repo.truckPageObject().ActivateTruck();
			
		Thread.sleep(3000);
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
		
		repo.truckPageObject().searchTruckonDashboard();
		
		flag=repo.truckPageObject().verifyTruckonDashboard();
		
		if(flag)
			log.info("Truck validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing after Activating on Truck Dashboard");
		
		Thread.sleep(3000);
	}
	

}

