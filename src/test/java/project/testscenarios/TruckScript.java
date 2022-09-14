package project.testscenarios;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import project.utility.ConfigurationSetup;
import project.utility.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TruckScript extends ConfigurationSetup{
	
	WebPageObjectCreation repo;
	
	String vin;
	
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
	
	@Test(priority = 5)
	public void CreatingNewTruck() throws InterruptedException 
	{
		
		repo=ObjectRepository.GetInstance();
		
		repo.truckPageObject().clickOnAddTruckDashboard();
		
		log.info("Calling API to generate Random VIN");
		
		vin=getVin();
		
		log.info("API Response for Random VIN : "+vin);
				
		map.put("identifier", vin+"123");
		map.put("vinnum", vin);
		map.put("regno", "MH12AB1010");
		map.put("Iname", "Test Insurance Name");
		map.put("Inumber","Test Insurance Number");
		map.put("Cname", "Test Cargo Insurance Name");
		map.put("Cnumber", "Test Cargo Insurance Number");
				
		repo.truckPageObject().EntertruckIdentifier(map.get("identifier"));
	
		String val = repo.truckPageObject().EntervinNo(map.get("vinnum"));
		
		if(val.equals("Incorrect"))
		{
			vin=getVin();
			map.put("vinnum", vin);
			val = repo.truckPageObject().EntervinNo(map.get("vinnum"));
			if(val.equals("Incorrect"))
				Assert.fail("Tried Entering Random VIN Twice but got Incorrect");
		}
	
		repo.truckPageObject().clickOnNextButton();
		
		repo.truckPageObject().EnterRegistrationNumber(map.get("regno"));
		
		repo.truckPageObject().clickOnNextButton();
		
		repo.truckPageObject().EnterInsuranceName(map.get("Iname"));
		
		repo.truckPageObject().EnterInsuranceNumber(map.get("Inumber"));
		
		repo.truckPageObject().EnterCargoInsuranceName(map.get("Cname"));
		
		repo.truckPageObject().EnterCargoInsuranceNumber(map.get("Cnumber"));
		
		repo.truckPageObject().clickOnNextButton();
		
		String retval=repo.truckPageObject().clickOnaddTruck();
		
		if(retval.equals("duplicate"))
		{
			vin=getVin();
			map.put("vinnum", vin);
			
			repo.truckPageObject().clickOnBackButton();
			
			repo.truckPageObject().clickOnBackButton();
			
			repo.truckPageObject().clickOnBackButton();
			
			repo.truckPageObject().EntervinNo(map.get("vinnum"));
			
			repo.truckPageObject().clickOnNextButton();
			
			repo.truckPageObject().clickOnNextButton();
			
			repo.truckPageObject().clickOnNextButton();
			
			retval=repo.truckPageObject().clickOnaddTruck();
			
			if(retval.equals("duplicate"))
				Assert.fail("Tried Entering Random VIN Twice but got duplicate");
			
		}
		
		repo.truckPageObject().closePopUp();
	}

	
	
	
	
	
	
	
	
	
	

}
