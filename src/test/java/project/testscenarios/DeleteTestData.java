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
	
	public static Logger log = Logger.getLogger(DeleteTestData.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority =1, groups = "Clean up")
	public void DeletingTestdata() throws InterruptedException 
	{
		try
		{
			repo.dashboardPageObject().clickOnVehicle();
			
			repo.dashboardPageObject().clickOnTrucks();
					
			repo.truckPageObject().searchTruckonDashboard();
	
			repo.truckPageObject().DeleteTruck();
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Unable to deleted Test Data of Truck");
		}

		Thread.sleep(5000);

		try
		{
			repo.dashboardPageObject().clickOnVehicle();
					
			repo.dashboardPageObject().clickOnTrailers();
					
			repo.trailerPageObject().SearchTrailer();
	
			repo.trailerPageObject().DeleteTrailer();
		}
		catch (Exception e) {
			// TODO: handle exception
			log.info("Unable to deleted Test Data of Trailer");

		}
	}
}
