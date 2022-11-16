package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ForgotPasswordScript {
	
    WebPageObjectCreation repo;
 	
	WebDriver driver;	
	
	public static Logger log = Logger.getLogger(ForgotPasswordScript.class);

	@BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }	
	
	@Test(priority = 1)
	public void ForgotPasswordclick() throws InterruptedException
	{		
		
		repo.forgotPasswordObject().ForgotPasswordClick();
							
		Assert.assertTrue(repo.forgotPasswordObject().ValidateForgotPassword());
		
		repo.forgotPasswordObject().enterAdminEmail();
		
		repo.forgotPasswordObject().resetPassword();
		
		Assert.assertTrue(repo.forgotPasswordObject().ValidatePasswordResetLinksend(),"Couldn't find an account associated with that email address");
				
		Driver.Refresh();
		
	}	

}
