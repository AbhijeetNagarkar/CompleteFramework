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
	
	
	@Test(priority = 10)
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
		
		repo.trailerPageObject().ClickOnNoMore();
		
	}
		}

