package project.MobileTestScenarios;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.Mediator.AndroidPageObjectRepository;
import project.MobilePages.LogbookLogin;
import project.utility.*;

public class MobileScript extends ConfigurationSetup {
		
	LogbookLogin LogbookLogin;
	
	public static Logger log = Logger.getLogger(MobileScript.class);
	
	@BeforeClass
	public void initialize()
	{
		LogbookLogin = AndroidPageObjectRepository.LogbookLogin();
	}
	
	@Test(priority = 0,groups = {"Login"})
	public void Login() throws InterruptedException
	{
	
		LogbookLogin.EnterPhoneNumber();
		
		LogbookLogin.EnterDOTNumber();
			
		LogbookLogin.ClickOnContinue();
			
		LogbookLogin.EnterPINNumber();
			
		LogbookLogin.ClickOnLogin();
			
	}
}	