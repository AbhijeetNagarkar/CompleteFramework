package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class MessageScript {

	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(MessageScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
	@Test(priority = 1,groups = {"Message"})
	public void NavigatingMessagePage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnMessages();
		
		repo.dashboardPageObject().clickOnMessagesSubMenu();
		
	}
	@Test(priority = 2,groups = {"Message"},dependsOnMethods = "NavigatingMessagePage" )
	public void SearchandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.MessagesPageObject().SearchandVerifyRecords(),"Search functionality not working as expected");
	}
	@Test(priority = 3,groups = {"Message"},dependsOnMethods = "NavigatingMessagePage" )
	public void FilterandVerification() throws InterruptedException 
	{
		Assert.assertTrue(repo.MessagesPageObject().SendMessageandVerification(),"Send Message functionality not working");
	}

}
