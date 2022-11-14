package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageAlerts {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageAlerts.class);
		
	public WebPageAlerts(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,120);
	}
	
	@FindBy(xpath = "//div[@class=\"tab-single  active\"]//span")
	WebElement activecount;
	
	@FindBy(xpath = "//div[@class=\"w-6/12 mx-1\"]//span[@class=\"text-lg text-blue-secondary font-semibold\"]")
	List<WebElement> count;
	
	

	
	
	
	
	
	
	
	
}
