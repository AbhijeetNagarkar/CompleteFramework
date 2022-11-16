package project.testscenarios;

import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class LogoutScript {
    WebPageObjectCreation repo;
	
	WebDriver driver;	
	
	public static Logger log = Logger.getLogger(LogoutScript.class);

	@BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }	
	
	@Test(priority = 2)
	public void LogoutClickflow() throws InterruptedException
	{		
		
		repo.logoutPageObject().ProfileMenuItemClick();
		
		repo.logoutPageObject().LogoutClick();	
				
		Assert.assertTrue(repo.logoutPageObject().ValidateLogout(),"Unable to logout"); 
		
		Driver.Refresh();
		
	}	


}
