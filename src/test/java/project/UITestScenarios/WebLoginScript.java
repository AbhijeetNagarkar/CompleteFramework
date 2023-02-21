package project.UITestScenarios;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.Mediator.WebPageObjectRepository;
import project.WebPages.WebPageLogin;
import project.utility.*;

public class WebLoginScript extends ConfigurationSetup {
		
	WebPageLogin LoginPage;
	
	public static Logger log = Logger.getLogger(WebLoginScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		LoginPage=WebPageObjectRepository.WebLoginPageObject();
	}

	@Test(priority = 0,groups = {"Login"})
	public void validUserNameandPassword() throws InterruptedException
	{
	
		LoginPage.enterUserName();
		
		LoginPage.enterUserPassword();
		
		LoginPage.signIn();
		
		Assert.assertTrue(LoginPage.validate());
	
	}
}	