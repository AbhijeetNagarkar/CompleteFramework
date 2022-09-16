package project.testscenarios;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import project.utility.*;

public class LoginScript extends ConfigurationSetup {
		
	WebPageObjectCreation repo;
	
	WebDriver driver;
	
	public static Logger log = Logger.getLogger(LoginScript.class);

	@Test(priority = 0)
	public void ConfigurationSetup() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1)
	public void blankUserNameandPassword() throws InterruptedException
	{
		repo.loginPageObject().enterUserName("");
		
		repo.loginPageObject().enterUserPassword("");
		
		repo.loginPageObject().signIn();
		
		Assert.assertTrue(repo.loginPageObject().validate());
		
		refreshPage();
		
	}
	
	@Test(priority = 2,alwaysRun = true)
	public void inValidUserNameandPassword() throws InterruptedException
	{
		repo.loginPageObject().enterUserName("Abhijeet@gmail.com");
		
		repo.loginPageObject().enterUserPassword("Abhijeet123");
		
		repo.loginPageObject().signIn();
		
		Assert.assertTrue(repo.loginPageObject().validate());
				
		refreshPage();
		
	}
	
	@Test(priority = 3,alwaysRun = true)
	public void validUserNameandPassword() throws InterruptedException
	{
	
		repo.loginPageObject().enterUserName();
		
		repo.loginPageObject().enterUserPassword();
		
		repo.loginPageObject().signIn();
		
		Assert.assertTrue(repo.loginPageObject().validate());
	
	}
}
