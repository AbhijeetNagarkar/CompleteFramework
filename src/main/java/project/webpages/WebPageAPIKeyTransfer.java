package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.mediator.Driver;

public class WebPageAPIKeyTransfer {
	
	WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageAPIKeyTransfer.class);
		
	public WebPageAPIKeyTransfer(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
	}
	
	@FindBy(xpath = "//div[@class=\"tab-single  active\"]//span")
	WebElement activecount;
	
	@FindBy(xpath = "//div[@class=\"tab-single \"]//span")
	WebElement inactivecount;
	
	@FindBy(xpath = "//tr[@class=\"ant-table-row ant-table-row-level-0\"]")
	List<WebElement> rowcount;
	
	@FindBy(xpath = "//button[@label=\"+ Share API KEY\"]")
	WebElement shareAPI;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement checkbox;
	
	@FindBy(xpath = "//button[@label=\"Send API Key\"]")
	WebElement sendapikey;
	
	
	

}
