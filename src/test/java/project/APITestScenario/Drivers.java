package project.APITestScenario;

import static project.APIBase.Consume.*;
import static project.APIConfiguration.Headers.*;
import static project.APIConfiguration.PathParameters.*;
import static project.APIConfiguration.QueryParameters.*;
import static project.APIConfiguration.RequestBody.*;
import static project.APIConfiguration.URL.*;
import static project.constants.SchemaDeclaration.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.restassured.module.jsv.JsonSchemaValidator;

import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import project.utility.ConfigurationSetup;

public class Drivers extends ConfigurationSetup {

	public static Logger log = Logger.getLogger(Drivers.class);
	
	Response response;

	@BeforeTest
	public void initialise()
	{
		initHeaders();
		initPathParameter();
		initQueryParameter();
		initBody();
	}
	
	@Test(priority=0, groups = "Drivers")
	public void GETDrivers(ITestContext context) throws IOException 
	{
		String targetAPI = APIurl+"client-services/api/v1/fms/drivers/";
		
		log.info("Consuming API : "+targetAPI);
		
		
		AddHeaders("TRUCKX-FMS-ID");
	
		AddQueryParameter("userId");

		response = GETAPI(targetAPI,
				GETHeaders(),GETQueryParameters(),GETPathParameters(),GETBody());
		
		
		log.info("Extracting the Response");
		
		float responsetime=(float)(response.getTimeIn(TimeUnit.MILLISECONDS))/1000;
		
		log.info("Response Time : "+responsetime);
		
		log.info("Response Code : "+res.statusCode()+"\n");
		
		context.setAttribute("Target API", targetAPI);

		context.setAttribute("Response Time", responsetime);
		
		context.setAttribute("Response Code",res.statusCode());
			
		Assert.assertEquals(response.statusCode(),200,"Received "+response.statusCode()+" status code");
		
		try
		{
			MatcherAssert.assertThat(res.body().asPrettyString(), JsonSchemaValidator.matchesJsonSchema(DriversSchema));
		}
		catch(Exception e)
		{
			Assert.fail("Unexpected JSON Schema");
		}
	}

	
}
