package project.RandomVinAPI;

import static io.restassured.RestAssured.given;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RandomVin {
	
	public static String getVin() {
		// TODO Auto-generated method stub
		Response res = (Response) given().accept(ContentType.JSON).
				   when().get("http://randomvin.com/getvin.php?type=fake")
				   .then().assertThat().statusCode(200).extract().body();
				
		String str = res.getBody().asString().trim();
		
		return str;
	}
}
