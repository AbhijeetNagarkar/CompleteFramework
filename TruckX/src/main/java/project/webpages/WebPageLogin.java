package project.webpages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static project.constants.GlobalDeclaration.*;

import java.util.List;


public class WebPageLogin {
	
	WebDriver driver;
	
	WebDriverWait wait;
	
	int flag =0; // 1-valid input 2-blank 3-invalid
	
		
	public WebPageLogin(WebDriver driverinstance)
	{
			driver=driverinstance;
			PageFactory.initElements(driver,this);
			wait = new WebDriverWait(driver,30);
			
	}

	@FindBy(id = "userName")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=\"Sign In\"]")
	WebElement submit;
	
	@FindBy(xpath="//div[@class=\"ant-form-explain\"]")
	List<WebElement> blankmsg;
	
	@FindBy(xpath="//span[@class=\"ant-alert-message\"]")
	WebElement alert;
	
	public void clear()
	{
		userName.clear();
		password.clear();
	}
	public void enterUserName()
	{
		flag=1;
		clear();
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(USERNAME);
	}
	public void enterUserPassword()
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(lOGINPASSWORD);
	}
	
	public void enterUserName(String name)
	{
		if(name=="")
			flag=2;
		else flag=3;
		clear();
		wait.until(ExpectedConditions.elementToBeClickable(userName));
		userName.sendKeys(name);
	}
	public void enterUserPassword(String pass)
	{
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pass);
	}
	
	public void signIn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(submit));
		submit.click();
	}
	
	public boolean validate() throws InterruptedException
	{
		Thread.sleep(4000);
		
		if(flag==1)
		{
			
			if(driver.findElement(By.xpath("//div[@class=\"flex flex-col\"]//*[text()=\"Logbook\"]")).getText().equalsIgnoreCase("Logbook"))
			{
				return true;
			}
			return false;
		}
		else if(flag==2)
		{
			
			if(blankmsg.get(0).getText().equals("Please input your username!") && blankmsg.get(1).getText().equals("Please input your Password!"))
			{
				return true;
			}
			return false;
		}
		else if(flag==3)
		{
			
			if(alert.getText().equals("Invalid User/Password!"))
			{
				return true;
			}
			return false;
		}
		return false;
	}
	
}
