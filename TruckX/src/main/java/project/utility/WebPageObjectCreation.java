package project.utility;

import org.openqa.selenium.WebDriver;

import project.webpages.WebPageLogin;

public class WebPageObjectCreation {

	private WebDriver driver;
	
	public WebPageObjectCreation(WebDriver driverinstance)
	{
		this.driver=driverinstance;
	}
	
	
	WebPageLogin loginPage;
		
	public WebPageLogin loginPageObject()
	{
		if(loginPage==null)
			loginPage = new WebPageLogin(driver);
		
		return loginPage;
	}
}
