package project.testscenarios;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class CompanyProfileScript {
	
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(CompanyProfileScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
		
	}
	
	@Test(priority = 47,groups = {"Company Profile"})
	public void NavigatingCompanyProfilePage() throws InterruptedException 
	{
		repo=ObjectRepository.GetInstance();
		
		repo.dashboardPageObject().clickOnProfile();
		
		repo.dashboardPageObject().clickOnCompanyProfile();
		
	}

	@Test(priority = 48,groups = {"Company Profile"},dependsOnMethods = "NavigatingCompanyProfilePage")
	public void CompanyProfileDetails() throws InterruptedException 
	{
		Assert.assertTrue(repo.companyProfilePageObject().VerifyDashboard(),"Incorrect Details showing on Company Profile Page-compared with input excel sheet");
		
	}
	@Test(priority = 49,groups = {"Company Profile"},dependsOnMethods = "NavigatingCompanyProfilePage")
	public void EditCompanyProfileFunctionality() throws InterruptedException 
	{
		Assert.assertTrue(repo.companyProfilePageObject().EditAddress(),"Edit functionality not working on Company Profile Page");
		
	}

}
