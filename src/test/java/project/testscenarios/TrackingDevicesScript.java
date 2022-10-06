package project.testscenarios;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import project.utility.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class TrackingDevicesScript {
	
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
	
	
	@Test(priority = 25)
	public void navigatingDevicesPage() throws InterruptedException 
	{
		
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnDevices();
				
		repo.dashboardPageObject().clickOnTrackingDevices();
		
		Thread.sleep(7000);
	}

}
