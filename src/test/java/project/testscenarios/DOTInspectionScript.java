package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class DOTInspectionScript {

	
WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(DOTInspectionScript.class);
	
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
		
	}
	
	@Test(priority = 1,groups = {"DOT Inspection"})
	public void NavigatingDOTInspectionPage() throws InterruptedException 
	{
				
		repo.dashboardPageObject().clickOnInspection();
		
		repo.dashboardPageObject().clickOnDOTInspection();
		
	}
	@Test(priority = 2,groups = {"DOT Inspection"},dependsOnMethods = "NavigatingDOTInspectionPage" )
	public void SwithOnDOTInspection() throws InterruptedException 
	{
				
		repo.DOTInspectionPageObject().SwitchOnDOTInspection();
		
	}
	@Test(priority = 3,groups = {"DOT Inspection"},dependsOnMethods = "NavigatingDOTInspectionPage")
	public void ValidateDOTInspection() throws InterruptedException 
	{
				
		repo.DOTInspectionPageObject().ValidateDOTInspection();
		
	}
	@Test(priority = 4,groups = {"DOT Inspection"},dependsOnMethods = "NavigatingDOTInspectionPage")
	public void SwitchOFFDOTInspection() throws InterruptedException 
	{
				
		repo.DOTInspectionPageObject().SwitchOFFDOTInspection();
		
	}
}
