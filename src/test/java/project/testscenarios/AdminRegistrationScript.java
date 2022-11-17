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

public class AdminRegistrationScript {

    WebPageObjectCreation repo;
 	
	WebDriver driver;	
	
	public static Logger log = Logger.getLogger(AdminRegistrationScript.class);

	@BeforeClass
    public void Fetct_Repository_Object() throws InterruptedException, IOException
    {
        repo = ObjectRepository.GetInstance();
    }	
	@Test(priority = 1)
	public void RegisterHereClick() throws InterruptedException
	{
		
		repo.adminRegistrationObject().RegisterbtnClick();
		
		repo.adminRegistrationObject().EnterFirstLastName();
		
		repo.adminRegistrationObject().EnterEmail();
		
		repo.adminRegistrationObject().EnterPhone();
		
		repo.adminRegistrationObject().EnterPasswords();
		
		repo.adminRegistrationObject().EnterDOTs();
		
		repo.adminRegistrationObject().EnterCustomerID();
		
		repo.adminRegistrationObject().clickOnNextButton();
		
		Assert.assertTrue(repo.adminRegistrationObject().ValidatekBlankFields(),"Blank fields validation failed");
		
		repo.adminRegistrationObject().EnterCarrierName();
		
		repo.adminRegistrationObject().SelectCarrierTimeZone();		
		
		repo.adminRegistrationObject().EnterLocationDetails();
		
	//	repo.adminRegistrationObject().CheckboxCaptcha();
		
		repo.adminRegistrationObject().CheckTermAndPolicychk();
		
		repo.adminRegistrationObject().clickOnAcceptandRegisterButton();
		
		Assert.assertTrue(repo.adminRegistrationObject().ValidateAdminRegisteredSuccessfully());					
		
				
		Driver.Refresh();
		
	}	
}
