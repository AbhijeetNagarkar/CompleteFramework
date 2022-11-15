package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DeleteTestData {

	WebPageObjectCreation repo;
	
	HashMap<String,String> devicemap;
	
	public static Logger log = Logger.getLogger(DashCameraScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 52,groups = {"Clean UP"})
	public void DeletingCreatedTestdata() throws InterruptedException 
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
				
		repo.truckPageObject().searchTruckonDashboard();

		repo.truckPageObject().DeleteTruck();

		Thread.sleep(5000);

		repo.dashboardPageObject().clickOnVehicle();
				
		repo.dashboardPageObject().clickOnTrailers();
				
		repo.trailerPageObject().changeFocus();
				
		repo.trailerPageObject().SearchTrailer();

		repo.trailerPageObject().DeleteTrailer();
	}
}
