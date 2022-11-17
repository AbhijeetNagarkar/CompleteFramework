package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.Driver;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class ForgotPasswordScript {
	
    WebPageObjectCreation repo;
 	
	public static Logger log = Logger.getLogger(ForgotPasswordScript.class);

	@BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }	
	
	@Test(priority = 1,groups = {"Login"})
	public void ForgotPasswordclick() throws InterruptedException
	{		
		repo.forgotPasswordObject().ForgotPasswordClick();
							
		Assert.assertTrue(repo.forgotPasswordObject().ValidateForgotPassword(),"Unable to Navigate Forget Password Page");
		
		repo.forgotPasswordObject().enterAdminEmail();
		
		repo.forgotPasswordObject().resetPassword();
		
		Assert.assertTrue(repo.forgotPasswordObject().ValidatePasswordResetLinksend(),"Couldn't find an account associated with that email address");
				
		Driver.Refresh();
		
	}	

}
