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

public class WebPageCompanyProfile {
	
WebDriver driver;
	
	WebDriverWait wait;

	public static Logger log = Logger.getLogger(WebPageCompanyProfile.class);
	
	HashMap<String,String> data;
		
	public WebPageCompanyProfile(WebDriver driverinstance)
	{
		driver=driverinstance;
			
		PageFactory.initElements(driver,this);
			
		wait=new WebDriverWait(driver,10);
		
		data=TestData.GetCompanyProfileData();
		
		
	}
	
	@FindBy(xpath = "//span[@class=\"edit-icon right\"]//*[name()=\"svg\"]")
	List<WebElement> editbutton;
	
	@FindBy(xpath = "/html/body/div[4]/div/span/div/div/div/span")
	WebElement msg;
	
	@FindBy(xpath = "//button[@label=\"Update\"]")
	WebElement updateButton;
	
	

}
	