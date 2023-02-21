package project.APIBase;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Consume {
	
	public static Response res;
	public static Response GETAPI(String API,HashMap<String,String> headers,
			HashMap<String,String> queryparameter,HashMap<String,String> pathparameter,String bodypart) 
	{
			res = (Response)given().relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.headers(headers).body(bodypart)
				.pathParams(pathparameter)
				.queryParams(queryparameter)
				.when()
				.get(API)
				.then()
				.extract().response();
			
				return res;
	}
		public static Response POSTAPI(String API,HashMap<String,String> headers,
			HashMap<String,String> queryparameter,HashMap<String,String> pathparameter,String bodypart)
	{
		res = (Response) given()
				.accept(ContentType.JSON)
				.headers(headers).body(bodypart)
				.pathParams(pathparameter)
				.queryParams(queryparameter)
				.when()
				.post(API)
				.then()
				.extract().body();
	
		return res;
	}
}
