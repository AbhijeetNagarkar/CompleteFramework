package project.testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import project.RandomVinAPI.RandomVin;
import project.mediator.ObjectRepository;
import project.mediator.TestData;
import project.utility.ConfigurationSetup;
import project.utility.WebPageObjectCreation;

public class TruckScript extends ConfigurationSetup{
	
	WebPageObjectCreation repo;
	
	String vin;
	
	@Test(priority = 4)
	public void NavigatingTrucksPage() throws InterruptedException 
	{
		
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnVehicle();
				
		repo.dashboardPageObject().clickOnTrucks();
		
		Thread.sleep(7000);
	}
	@Test(priority = 5, dependsOnMethods = "NavigatingTrucksPage" )
	public void CreatingNewTruck()
	{
		repo.truckPageObject().clickOnAddTruckDashboard();
		
		log.info("Calling API to generate Random VIN");
		
		vin=RandomVin.getVin();
		
		if(vin.equalsIgnoreCase(""))
			vin=RandomVin.getVin();
		
		log.info("API Response for Random VIN : "+vin);
	
		TestData.GetVehicleData().put("Truck Identifier", vin+"123");
		TestData.GetVehicleData().put("VIN Number", vin);
		try
		{
			repo.truckPageObject().EntertruckIdentifier();
		
			String val = repo.truckPageObject().EntervinNo();
			
			if(val.equals("Incorrect"))
			{
				vin=RandomVin.getVin();
				TestData.GetVehicleData().put("VIN Number", vin);
				val = repo.truckPageObject().EntervinNo();
				if(val.equals("Incorrect"))
					Assert.fail("Tried Entering Random VIN Twice but got Incorrect");
			}
	
			repo.truckPageObject().clickOnNextButton();
			
			repo.truckPageObject().EnterRegistrationNumber();
			
			repo.truckPageObject().clickOnNextButton();
			
			repo.truckPageObject().EnterInsuranceName();
			
			repo.truckPageObject().EnterInsuranceNumber();
			
			repo.truckPageObject().EnterCargoInsuranceName();
			
			repo.truckPageObject().EnterCargoInsuranceNumber();
			
			repo.truckPageObject().clickOnNextButton();
			
			String retval=repo.truckPageObject().clickOnaddTruck();
			
			if(retval.equals("duplicate"))
			{
				vin=RandomVin.getVin();
				TestData.GetVehicleData().put("VIN Number", vin);
				
				repo.truckPageObject().clickOnBackButton();
				
				repo.truckPageObject().clickOnBackButton();
				
				repo.truckPageObject().clickOnBackButton();
				
				repo.truckPageObject().EntervinNo();
				
				repo.truckPageObject().clickOnNextButton();
				
				repo.truckPageObject().clickOnNextButton();
				
				repo.truckPageObject().clickOnNextButton();
				
				retval=repo.truckPageObject().clickOnaddTruck();
				
				if(retval.equals("duplicate"))
					Assert.fail("Tried Entering Random VIN Twice but got duplicate");
			}
			repo.truckPageObject().closePopUp();
		}
		catch (InterruptedException e) {
			
			log.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
}
	
	@Test(priority = 6, dependsOnMethods = "CreatingNewTruck")
	public void SearchTruckOnDashboard() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		repo.truckPageObject().searchTruckonDashboard();
	}
	
	@Test(priority = 7, dependsOnMethods = "SearchTruckOnDashboard")
	public void VerifyTruckOnDashboard() throws InterruptedException 
	{
		boolean flag=repo.truckPageObject().verifyTruckonDashboard();
		if(flag)
		{
			
			//System.out.println("Validated successfully on dashboard");
		}
		else Assert.fail("Incorrect data showing on Dashboard for Newly Added Truck");
	}
	
	@Test(priority = 8, dependsOnMethods = "VerifyTruckOnDashboard")
	public void VerifyTruckOnVehicleDetails() throws InterruptedException
	{
		boolean flag=repo.truckPageObject().verifyTruckDetails();
		
		if(flag)
		{
			//System.out.println("Validated successfully on Vehicle Details Page");
		}
		else Assert.fail("Incorrect data showing on Vehicle Details for Newly Added Truck");
		
		
		
	}
	
}
