package project.webpages;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import project.mediator.TestData;

public class WebPageForgotPassword {
	
    WebDriver driver;
	
	WebDriverWait wait;
	
	HashMap<String, String> forgotpasswordmap;
	
	public static Logger log = Logger.getLogger(WebPageForgotPassword.class);	
		
	
	public WebPageForgotPassword(WebDriver driverinstance)
	{
		driver=driverinstance;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver,30);
		forgotpasswordmap = TestData.GetForgotPasswordData();
		
	}
		
	@FindBy(xpath = "//a[text() = 'Forgot Password?']")
	WebElement ForgotPasswordLink;
	
	@FindBy(id="email")
	WebElement email;
		
	@FindBy(xpath="//button[@type=\"submit\"]")	
	WebElement ResetPasswordbutton;	
	
	public void ForgotPasswordClick() throws InterruptedException
	{
		Thread.sleep(2000);
		try
		{
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordLink));
		ForgotPasswordLink.click();
		log.info("Clicked on Forgot password link");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to click on forgot password link");
		}
	}
	
	public void enterAdminEmail()
	{
		try
		{
			
			wait.until(ExpectedConditions.elementToBeClickable(email));		
			email.sendKeys(forgotpasswordmap.get("adminemail"));
			log.info("Admin Email Entered");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to Enter Admin email in Login Page");
		}
		
	}
	
	public void resetPassword()
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(ResetPasswordbutton));
		ResetPasswordbutton.click();
		
		log.info("Clicked on Reset Password button");
		}
		catch(Exception e)
		{
			Assert.fail("Unable to clicked on Reset password button of Forgot Password Page");
		}
	}
	
	public boolean ValidateForgotPassword() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("Validating forgot password flow");				
	 
			try
			{			
				if(driver.getCurrentUrl().equals("https://web.truckx.com/#/forgot-password/admin"))
				{
				log.info("Validated forgot password URL after click");
					
					
				}
				else return false;
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
			}
										
				log.info("Forgot password URL validated successfully");
			
				return true;
		}
	public boolean ValidatePasswordResetLinksend() throws InterruptedException
	{
		Thread.sleep(5000);
		log.info("Validating Reset link/email sent flow");				
	 
			try
			{			
				if(driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Email sent"))
				{			
					
				log.info("Validated forgot password link/email sent successfully");		
				return true;
				
				}
				else if(driver.findElement(By.xpath("//div[@class='text-lg']")).getText().contains("We couldn't find an account associated with that email address."))
				{
					log.info("Couldn't find an account associated with that email address. Wrong email validated successfully");					
					return false;
				}
			 return false;
			}
			catch(Exception e)
			{
				log.info(e.getMessage());
				return false;
			}									
						
				
		}

}
