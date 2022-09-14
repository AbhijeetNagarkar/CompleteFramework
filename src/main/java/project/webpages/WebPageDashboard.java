package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.utility.Driver;



public class WebPageDashboard {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageDashboard.class);
	
	long starttime=0;
	
	long totaltime=0;
	
		
	public WebPageDashboard(WebDriver driverinstance)
	{
			driver=driverinstance;
			
			PageFactory.initElements(driver,this);
			
			wait = new WebDriverWait(driver,60);
			
	}

	@FindBy(xpath = "//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")
	WebElement vehicles;
	
	@FindBy(xpath = "//div[@class=\"custom-drop-submenu\"]//span[text()=\"Trucks\"]")
	WebElement trucks;
	
		
	public void clickOnVehicle()
	{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flex flex-col\"]//span[text()=\"Vehicles\"]")));
		
		vehicles.click();
		
		log.info("Clicked on Vehicles Menu");
	}
	public void clickOnTrucks()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"custom-drop-submenu\"]//span[text()=\"Trucks\"]")));
		
		trucks.click();
		
		log.info("Clicked on Trucks from Sub Menu");
	}
	public void refresh()
	{
		Driver.GetDriver().navigate().refresh();
	}

}
