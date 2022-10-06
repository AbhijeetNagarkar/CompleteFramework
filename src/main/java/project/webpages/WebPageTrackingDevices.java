package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageTrackingDevices {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageTrackingDevices.class);
	
	long starttime=0;
	
	long totaltime=0;

	public WebPageTrackingDevices(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,20);
	}
	
	@FindBy(xpath = "//button[text()=\"+ Add Devices\"]")
	WebElement addDevices;

	public void clickOnDevices() {
		// TODO Auto-generated method stub
		
	}

	public void clickOnTrackingDevices() {
		// TODO Auto-generated method stub
		
	}
	
	
}
