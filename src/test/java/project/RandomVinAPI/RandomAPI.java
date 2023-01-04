package project.RandomVinAPI;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RandomAPI {
	
	
	public static String getVin() {
		// TODO Auto-generated method stub
		Response res = (Response) given().accept(ContentType.JSON).
				   when().get("http://randomvin.com/getvin.php?type=fake")
				   .then().assertThat().statusCode(200).extract().body();
				
		String str = res.getBody().asString().trim();
		
		return str;
	}
	
	public static String getMobileNumber() {
		// TODO Auto-generated method stub
		Response res = (Response) given().accept(ContentType.JSON).header("X-Api-Key","ae577abe1aa24f34afbc25822c662db5", null).
				   when().get("https://randommer.io/api/Phone/Generate?CountryCode=US&Quantity=1")
				   .then().assertThat().statusCode(200).extract().body();
				
		String str = res.asPrettyString();
		
		str = str.substring(10,22);
		
		return str;
	}
}
