package project.webpages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.mediator.TestData;

public class WebPageDrivers {

	WebDriver driver;

	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageDrivers.class);
	
	HashMap<String,String> driversdata;
		
	public WebPageDrivers(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,120);
		
		driversdata=TestData.GetDriversData();
	}
	
	
}
