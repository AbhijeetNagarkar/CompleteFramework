package project.testscenarios;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class LogoutScript {
 
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(LogoutScript.class);

	@BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }	
	
	@Test(priority = 3,groups = {"Login"})
	public void LogoutClickflow() throws InterruptedException
	{		
		
		repo.logoutPageObject().ProfileMenuItemClick();
		
		repo.logoutPageObject().LogoutClick();	
				
		Assert.assertTrue(repo.logoutPageObject().ValidateLogout(),"Unable to logout"); 
		
		Driver.Refresh();
		
	}	


}
