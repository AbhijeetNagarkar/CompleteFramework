package project.utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import project.webpages.WebPageDashboard;
import project.webpages.WebPageLogin;
import project.webpages.WebPageTruck;

public class WebPageObjectCreation {

	private WebDriver driver;
	
	public static Logger log = Logger.getLogger(WebPageObjectCreation.class);
	
	public WebPageObjectCreation(WebDriver driverinstance)
	{
		this.driver=driverinstance;
		log.info("Repository object created to fetch Web Pages object");
	}
	
	
	WebPageLogin loginPage;
	
	WebPageDashboard dashboardPage;
	
	WebPageTruck truckPage;
	
		
	public WebPageLogin loginPageObject()
	{
		if(loginPage==null)
		{
			log.info("Login page object created");
			loginPage = new WebPageLogin(driver);
		}
		return loginPage;
	}
	public WebPageDashboard dashboardPageObject()
	{
		if(dashboardPage==null)
		{
			log.info("Dashboard page object created");
			dashboardPage = new WebPageDashboard(driver);
		}
		return dashboardPage;
	}
	public WebPageTruck truckPageObject()
	{
		if(truckPage==null)
		{
			log.info("Truck page object created");
			truckPage = new WebPageTruck(driver);
		}
		return truckPage;
	}
}
