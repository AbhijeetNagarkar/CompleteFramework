package project.webpages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageDeletedDrivers {

WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageDeletedDrivers.class);
	
	public WebPageDeletedDrivers(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,10);
			
	}

	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//td[@class=\"rc-table-cell\"]//*[text()=\"View Logbook\"]")
	List<WebElement> viewlogbook;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span[text()=\"Deleted Drivers\"]")
	WebElement changefocus;
	
	
	
	
	
	
	
}
