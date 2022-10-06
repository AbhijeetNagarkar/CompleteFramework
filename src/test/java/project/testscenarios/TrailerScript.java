package project.testscenarios;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import project.utility.ObjectRepository;
import project.utility.TestData;
import project.utility.WebPageObjectCreation;

public class TrailerScript {

	WebPageObjectCreation repo;
	
	String vin;
	
	boolean flag;
	
	HashMap<String,String> map=new HashMap<String,String>();
	
	public static Logger log = Logger.getLogger(TruckScript.class);
	
	private String getVin() {
		// TODO Auto-generated method stub
		Response res = (Response) given().accept(ContentType.JSON).
				   when().get("http://randomvin.com/getvin.php?type=fake")
				   .then().assertThat().statusCode(200).extract().body();
				
		String str = res.getBody().asString().trim();
		
		return str;
	}
	@Test(priority = 9)
	public void navigatingTrailerPage() throws InterruptedException
	{
		repo=ObjectRepository.GetInstance();
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		Thread.sleep(5000);
	}
	
	
	@Test(priority = 10, dependsOnMethods = "navigatingTrailerPage" )
	public void CreatingNewTrailer() throws InterruptedException
	{
		
		repo=ObjectRepository.GetInstance();
		
		map=TestData.GetVehicleData();
		
		repo.trailerPageObject().clickOnAddTrailerDashboard();
		
		log.info("Calling API to generate Random VIN");
		
		vin=getVin();
		
		log.info("API Response for Random VIN : "+vin);
		
		map.put("traileridentifier", vin);
		
		repo.trailerPageObject().EntertrailerIdentifier(map.get("traileridentifier"));
		
		repo.trailerPageObject().ClickOnSave();
		
		repo.trailerPageObject().ClickOnNo();
		
	}
	@Test(priority = 11,dependsOnMethods = "CreatingNewTrailer")
	public void VerifyNewlyAddedTrailer() throws InterruptedException
	{	
		repo.trailerPageObject().SearchTrailer(map.get("traileridentifier"));
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard(map.get("traileridentifier"),"");
		
		if(flag)
			log.info("Trailer validated on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
			
	
	}
	
	/*
	@Test(priority = 12,dependsOnMethods = "VerifyNewlyAddedTrailer")
	public void AssignTrailerToTruck() throws InterruptedException
	{
	
		repo.trailerPageObject().ClickOnAssign();
		
		repo.trailerPageObject().ClickOnTruckDropdown(); //
		
		String selectedtruck = repo.trailerPageObject().SelectTruckFromDropDown();
		
		map.put("selectedtruck", selectedtruck);
		
		repo.trailerPageObject().ClickOnUpdate();
	}
	
	@Test(priority = 13, dependsOnMethods = "AssignTrailerToTruck")
	public void VerifyAssignedTrailerToTruck() throws InterruptedException
	{
		flag=repo.trailerPageObject().VerifyAssignedTrailerOnDashboard(map.get("traileridentifier"),map.get("selectedtruck"));
		
		if(flag)
			log.info("Trailer validated after Assigned on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	
	@Test(priority = 14, dependsOnMethods = "VerifyAssignedTrailerToTruck" )
	public void UnAssignTrailerFromTruck() throws InterruptedException
	{	
		repo.trailerPageObject().ClickOnUnAssign();
		
		repo.trailerPageObject().ClickOnYes();
	}
	@Test(priority = 15, dependsOnMethods = "UnAssignTrailerFromTruck")
	public void VerifyUnAssignedTrailerToTruck() throws InterruptedException
	{
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard(map.get("traileridentifier"),"");
		
		if(flag)
			log.info("Trailer validated after UnAssigned on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	*/
	@Test(priority = 16, dependsOnMethods = "VerifyNewlyAddedTrailer")
	public void EditTrailer() throws InterruptedException
	{
	
		map.put("traileridentifier",(map.get("traileridentifier"))+"123");
		
		repo.trailerPageObject().EditTrailer(map.get("traileridentifier"));
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard(map.get("traileridentifier"),"");
		
		if(flag)
			log.info("Trailer validated after Edit on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
	}
	@Test(priority = 17, dependsOnMethods = "VerifyNewlyAddedTrailer")
	public void DeleteTrailer() throws InterruptedException
	{
		repo.trailerPageObject().DeleteTrailer();
		
		repo.trailerPageObject().SearchTrailer(map.get("traileridentifier"));
		
		flag=repo.trailerPageObject().VerifyDeletedTrailer();
		
		if(flag)
			log.info("Deleted Trailer Verified on Dashboard successfully");
		else 
			Assert.fail("Deleted Trailer showing on Trailer Dashboard");
	
			
	}
	@Test(priority = 18)
	public void navigatingDeletedTrailerPage() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrailers();
		
		Thread.sleep(5000);
	}
	@Test(priority = 19, dependsOnMethods ="navigatingDeletedTrailerPage" )
	public void ActivateTrailer() throws InterruptedException
	{
		repo.trailerPageObject().ActivateTrailer(map.get("traileridentifier"));
		
		Thread.sleep(3000);
	}
	
	@Test(priority = 20, dependsOnMethods = "ActivateTrailer")
	public void verifyActivateTrailer() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrailers();
		
		repo.trailerPageObject().changeFocus();
		
		repo.trailerPageObject().SearchTrailer(map.get("traileridentifier"));
		
		flag=repo.trailerPageObject().VerifyUnAssignedTrailerOnDashboard(map.get("traileridentifier"),"");
		
		if(flag)
			log.info("Trailer validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing on Trailer Dashboard");
		
		repo.trailerPageObject().DeleteTrailer();
	}
	
	@Test(priority = 21)
	public void DeleteTruck() throws InterruptedException
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
		
		repo.truckPageObject().searchTruckonDashboard(map.get("vinnum")); 
		
		repo.truckPageObject().DeleteTruck();
		
		Thread.sleep(3000);
		
		repo.truckPageObject().searchTruckonDashboard(map.get("vinnum"));
		
		flag=repo.truckPageObject().verifyDeletedTruckonDashboard(map);
		
		if(flag)
			Assert.fail("Deleted Truck showing as Active");
		else 
			log.info("Verified Deleted Truck on Dashboard");
	}
	@Test(priority = 22)
	public void navigatingDeletedTruckPage() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnDeletedTrucks();
		
		Thread.sleep(5000);
	}
	@Test(priority = 23)
	public void ActivateTruck() throws InterruptedException
	{
		repo.truckPageObject().ActivateTruck(map.get("vinnum"));
			
		Thread.sleep(3000);
	}
	@Test(priority = 24)
	public void verifyActivateTruck() throws InterruptedException
	{
		repo.dashboardPageObject().clickOnVehicle();
		
		repo.dashboardPageObject().clickOnTrucks();
		
		repo.truckPageObject().searchTruckonDashboard(map.get("vinnum"));
		
		flag=repo.truckPageObject().verifyTruckonDashboard(map);
		
		if(flag)
			log.info("Truck validated after Activating on Dashboard successfully");
		else 
			Assert.fail("Incorrect details showing after Activating on Truck Dashboard");
		
		repo.truckPageObject().DeleteTruck();
		
		Thread.sleep(3000);
	}

}

