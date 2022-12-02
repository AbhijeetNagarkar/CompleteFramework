package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.RandomVinAPI.RandomVin;
import project.mediator.ObjectRepository;
import project.mediator.TestData;
import project.utility.WebPageObjectCreation;

public class TrailerScript {

	WebPageObjectCreation repo;
	
	String vin;
	
	boolean flag;
	
	HashMap<String,String> vehiclemap,trailermap;
	
	public static Logger log = Logger.getLogger(TruckScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 9, groups = {"Trailers"})
	public void NavigatingTrailerPage() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 10, dependsOnMethods = "NavigatingTrailerPage",groups = {"Trailers"} )
	public void CreatingNewTrailer() throws InterruptedException
	{
		
		repo=ObjectRepository.GetInstance();
		
		vehiclemap=TestData.GetVehicleData();
		
		trailermap=TestData.GetTrailerData();
		
		repo.trailerPageObject().clickOnAddTrailerDashboard();
		
		log.info("Calling API to generate Random VIN");
		
		vin=RandomVin.getVin();
		
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
			
	@Test(priority = 12,dependsOnMethods = "CreatingNewTrailer",groups = {"Trailers"})
	public void AssignTrailerToTruck() throws InterruptedException
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
	
		
	@Test(priority = 14, dependsOnMethods = {"AssignTrailerToTruck"},groups = {"Trailers"} )
	public void UnAssignTrailerFromTruck() throws InterruptedException
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
	
	@Test(priority = 16, dependsOnMethods = "CreatingNewTrailer",groups = {"Trailers"} )
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
	@Test(priority = 17, dependsOnMethods = "CreatingNewTrailer",groups = {"Trailers"})
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
	@Test(priority = 18, dependsOnMethods = "DeleteTrailer",groups = {"Trailers"})
	public void NavigatingDeletedTrailerPage() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrailers();
		
		Thread.sleep(5000);
	}
	@Test(priority = 19, dependsOnMethods ="NavigatingDeletedTrailerPage",groups = {"Trailers"} )
	public void ActivateTrailer() throws InterruptedException
	{
		repo.trailerPageObject().ActivateTrailer();
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 20, dependsOnMethods = "ActivateTrailer",groups = {"Trailers"})
	public void VerifyActivateTrailer() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		repo.trailerPageObject().changeFocus();
		
		repo.trailerPageObject().SearchTrailer();
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard();
		
		if(flag)
			log.info("Trailer validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
		
	//	repo.trailerPageObject().DeleteTrailer();
	}
	
	@Test(priority = 21,groups = {"Trucks"})
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
	@Test(priority = 22,groups = {"Trucks"})
	public void NavigatingDeletedTruckPage() throws InterruptedException
	{
		repo.dashboardPageObject().refresh();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrucks();
		
		Thread.sleep(5000);
	}
	@Test(priority = 23, dependsOnMethods = "NavigatingDeletedTruckPage",groups = {"Trucks"})
	public void ActivateTruck() throws InterruptedException
	{
		repo.truckPageObject().ActivateTruck();
			
		Thread.sleep(3000);
	}
	@Test(priority = 24, dependsOnMethods = "ActivateTruck",groups = {"Trucks"} )
	public void VerifyActivateTruck() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
		
		repo.truckPageObject().searchTruckonDashboard();
		
		flag=repo.truckPageObject().verifyTruckonDashboard();
		
		if(flag)
			log.info("Truck validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing after Activating on Truck Dashboard");
		
	//	repo.truckPageObject().DeleteTruck();
		
		Thread.sleep(3000);
	}

}

