package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageFeature {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageFeature.class);
		
	public WebPageFeature(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//div[@class=\"flex items-center justify-between px-2\"]//h1")
	WebElement msg;
	
	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	public Boolean verifyNewUpdates() throws InterruptedException
	{
		try
		{
		Thread.sleep(3000);
		changefocus.click();
		
		if(msg.getText().equalsIgnoreCase("TruckX Continously Improves to Give You the Best Experience!"))
		{
			log.info("Landed on New Updates and showing message");
			return true;
		}
		else
		{
			log.info("Unable to land New Updates and not showing Continously Improves msg");
			return false;
		}
		}
		catch (Exception e) {
			log.info("Caught Exception While verifying New Updates");
			return false;
		}
		
	}
	
}
