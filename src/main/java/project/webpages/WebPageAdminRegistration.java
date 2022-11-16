package project.webpages;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheetConditionalFormatting;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import project.mediator.TestData;

public class WebPageAdminRegistration {

    WebDriver driver;
	
	WebDriverWait wait;
	
	FluentWait<WebDriver> fwait;
	
	HashMap<String, String> adminRegmap;
	
	public static Logger log = Logger.getLogger(WebPageAdminRegistration.class);	
	
	public WebPageAdminRegistration(WebDriver driverinstance)
	{
		driver=driverinstance;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,30);
		adminRegmap = TestData.GetAdminRegistrationData();
		
	}
		
	@FindBy(xpath ="//a[@href=\"#/register/\"]")
	WebElement registerLink;
	
	@FindBy(xpath ="//h3[text()=\"Personal Information\"]")
	WebElement lblPersonalInfo;
	
	@FindBy(xpath="//h3[text()=\"Carrier Information\"]")
	WebElement lblCarrierInfo;
	
	@FindBy(xpath ="//input[@id=\"first_name\"]")
	WebElement FirstName;
	
	@FindBy(xpath ="//input[@id=\"last_name\"]")
	WebElement LastName;
	
	@FindBy(xpath ="//input[@id=\"email\"]")
	WebElement Email;
	
	@FindBy(xpath ="//input[@id=\"phone\"]")
	WebElement PhoneNo;
	
	@FindBy(xpath ="//input[@id=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath ="//input[@id=\"confirm_password\"]")
	WebElement ConfirmPassword;
	
	@FindBy(id ="DOT")
	WebElement DOT;
	
	@FindBy(xpath ="//input[@id=\"dot_number_confirm\"]")
	WebElement ConfirmDOT;
	
	@FindBy(xpath ="//input[@id=\"subscription_id\"]")
	WebElement CustomerID;
	
	@FindBy(xpath ="//div[@class=\"action-buttons\"]//button[@label=\"Next\"]")
	WebElement Next;
	
	//check blank fields
	@FindBy(xpath="//div[@class=\"ant-form-explain\"][text()=\"Please enter First name.\"]")
	WebElement blankFirst;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"][text()=\"Please enter email\"]")
	WebElement blankEmail;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"][text()=\"Please enter DOT number\"]")
	WebElement blankDOT;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"][text()=\"Please enter Subscription ID\"]")
	WebElement blankCustomerID;
	
	@FindBy(xpath="//input[@id=\"carrier_name\"]")
	WebElement CarrierName;
	
	@FindBy(xpath="//div[@id=\"cycle_timezone\"]")
	WebElement CarrierTimeZone;
	
	@FindBy(xpath = "//input[@class=\"location-search-input\"]")
	WebElement location;
	
	@FindBy(id="//span[@id=\"recaptcha-anchor\"]")
	WebElement CaptchCheck;
	
	@FindBy(xpath="//span[@class=\"ant-checkbox\"]")
	WebElement TermChkbox;
	
	@FindBy(xpath="//button[@label=\"Accept & Register\"]")
	WebElement RegisterAdmin;
	
	@FindBy(xpath ="//div[@class=\"text-lg\"][text()=\"Incorrect Customer ID or DOT number. Please refer to your email for the right values\"]")
	WebElement AdminRegistrationError;
	
	@FindBy(xpath="")
	WebElement AdminRegistrationSuccess;
		
	public void RegisterbtnClick() throws InterruptedException
	{
		Thread.sleep(5000);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(registerLink));
		registerLink.click();
		log.info("Clicked on 'Register here' link");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on 'Register here' link");
		}
	}
	
	public void AddPersonalCompanyDetails() throws InterruptedException
	{
		Thread.sleep(5000);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(lblPersonalInfo));
		
		Email.sendKeys("rupali@truckx.com");
		PhoneNo.sendKeys("3928632896");
		Password.sendKeys("123456");
		ConfirmPassword.sendKeys("123456");
		DOT.sendKeys("112211");
		ConfirmDOT.sendKeys("112211");
		CustomerID.sendKeys("cus_LaajxEVariHxrh");
		Next.click();
		wait.until(ExpectedConditions.visibilityOf(lblPersonalInfo));
		

		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on 'Register here' link");
		}
	}
	
	public void EnterFirstLastName()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(lblPersonalInfo));	
		FirstName.sendKeys(adminRegmap.get("First"));
		LastName.sendKeys(adminRegmap.get("Last"));			
		log.info("Entered First and Last name");
		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter First and Last Name in Personal Information");
		}
	}
	public void EnterEmail()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(Email));	
		Email.sendKeys(adminRegmap.get("Email"));
		log.info("Entered email");	
	
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Email address in Personal Information");
		}
	}
	
	public void EnterPhone()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(PhoneNo));
		PhoneNo.sendKeys("1234567890");
		log.info("Entered phone number");		
		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Phone address in Personal Information");
		}
	}
	public void EnterPasswords()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(Password));
		Password.sendKeys("123456");
		ConfirmPassword.sendKeys("123456");
		log.info("Entered password");		
		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter password/confirm password in Personal Information");
		}
	}
	
	public void EnterDOTs()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(DOT));
		DOT.sendKeys("112211");
		ConfirmDOT.sendKeys("112211");
		log.info("Entered DOTs number");
				
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter DOT/ confirm DOT in Company Information");
		}
	}
	public void EnterCustomerID()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(CustomerID));
		CustomerID.sendKeys(adminRegmap.get("CustomerID"));
		log.info("Entered Customer ID");	
		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Customer ID in Company Information");
		}
	}
	
	
	public void clickOnNextButton()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(Next));		
		Next.click();		
		log.info("Clicked On Next");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Next button");
		}
	}
	
	public void EnterCarrierName()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(lblPersonalInfo));			
		CarrierName.sendKeys(adminRegmap.get("CarrierName"));	
		log.info("Entered carrier name");		
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Carrier Name");
		}
	}
	public void SelectCarrierTimeZone()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(CarrierTimeZone));	
		CarrierTimeZone.click();
		Thread.sleep(4000);
        List<WebElement> LTimezone=driver.findElements(By.xpath("//ul[@class=\"ant-select-dropdown-menu  ant-select-dropdown-menu-root ant-select-dropdown-menu-vertical\"]//li"));
       
        for(WebElement ele : LTimezone)
        {            
      		if(ele.getText().equalsIgnoreCase(adminRegmap.get("Timezone")))
        	{
        		ele.click();
        		break;
        	}
        }
        log.info("Entered carrier timezone");	
        }
		catch(Exception e)
		{
			Assert.fail("Unable to select Carrier Timezone");
		}
	}
	
	
	public void EnterLocationDetails()
	{
		try
		{
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(location));				
		location.sendKeys(adminRegmap.get("Location"),Keys.TAB);
		Thread.sleep(5000);			
		List<WebElement> address=driver.findElements(By.xpath("//div[@class=\"autocomplete-dropdown-container\"]//div"));
		
		Thread.sleep(5000);   
		if(address.size()>1)
	        address.get(1).click();       
		Thread.sleep(5000);
		log.info("Entered location details");	
		}
		catch(Exception e)
		{
			Assert.fail("Unable to select location");
		}
	}
	
	public void CheckboxCaptcha()
	{
		
		try
		{   
			System.out.println("Before");
		driver.findElements(By.xpath("//div[@class=\"rc-inline-block\"]//div[@class=\"rc-anchor-center-item rc-anchor-checkbox-holder\"]")).get(1).click();
			
		System.out.println("After Captcha");		
			
		log.info("Checked Captcha checkbox");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to check Captcha checkbox");
		}
	}
	public void CheckTermAndPolicychk()
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(TermChkbox));		
		Boolean isenabled =TermChkbox.isEnabled();
		if(isenabled == true)
			TermChkbox.click();
			
		log.info("Clicked On 'I Have read and accept the terms of sevice and privacy policy' check");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on policy Check");
		}
	}
	
	public void clickOnAcceptandRegisterButton()
	{
		try
		{				
		driver.findElement(By.xpath("//div[@class=\"action-buttons\"]//button[@label=\"Accept & Register\" and @type=\"submit\" and @class=\"ant-btn truckx-button primary-btn    default  ant-btn-primary\"]")).click();
			
		log.info("Clicked On Accept and Register button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on Accept and Register button");
		}
	}
	public boolean ValidatekBlankFields()
	{
		try
		{
	
		if(lblCarrierInfo.isDisplayed())
		{
			log.info("Personal details entered");
			return true;
		}
		else
		{
			log.info("Blank fields validation failed");
			return false;
		}			
				
		}
		catch(Exception e)
		{
			Assert.fail("Blank fields validation failed");
			return false;
		}
	}
	
	public boolean ValidateAdminRegisteredSuccessfully() throws InterruptedException
	{
		Thread.sleep(4000);
		log.info("Validating Admin Registration Success/Fail flow");				
	 
//			try
//			{   
//				if((driver.findElement(By.xpath("//div[@class=\"text-lg\"]")).isDisplayed()) && (driver.findElement(By.xpath("//div[@class=\"text-lg\"]")).getText().contains("Incorrect Customer ID or DOT number. Please refer to your email for the right values")))
//				{		
//					
//				log.info("Incorrect Customer ID or DOT number.");		
//				return true;
//				
//				}
//				else if((driver.findElement(By.xpath("//h1")).isDisplayed()) && (driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Email sent")))
//				{
//					log.info("Admin registered successfully.");					
//					return false;
//				}
//				
//			 return false;
//			}
//			catch(Exception e)
//			{
//				log.info(e.getMessage());
//				return false;
//			}	
		return true;
	}
	
	
}


