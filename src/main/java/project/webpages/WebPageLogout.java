package project.webpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebPageLogout {
    
	WebDriver driver;
	
	WebDriverWait wait;
	
	public static Logger log = Logger.getLogger(WebPageLogout.class);
	
	
	public WebPageLogout(WebDriver driverinstance)
	{
		driver=driverinstance;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,30);
		
	}
	
	@FindBy(xpath="//div[@class=\"flex items-center header-dropdown\"]")
	WebElement ProfileMenuItem;
	
	@FindBy(xpath="//div[@class=\"flex justify-between\"]//span[text()=\"Logout\"]")
	WebElement Logout;
	
	public void ProfileMenuItemClick() throws InterruptedException
	{
		Thread.sleep(10000);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(ProfileMenuItem));
		ProfileMenuItem.click();
		log.info("Clicked on profile menu item");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on profile menu item");
		}
	}
	
	public void LogoutClick() throws InterruptedException
	{
		Thread.sleep(2000);

		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(Logout));
		Logout.click();
		log.info("Clicked on Logout button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to logout");
		}
	}
	
	public boolean ValidateLogout() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("Validating Logout flow");				
	 
			try
			{			
				if(driver.getCurrentUrl().equals("https://web.truckx.com/#/login"))
				{
				log.info("Validated login URL after logout click");
					
				return true;	
				}
				else return false;
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
				return false;
			}						
					
			
		}
	}
	
	
	

