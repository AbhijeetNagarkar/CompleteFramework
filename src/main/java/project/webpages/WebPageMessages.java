package project.webpages;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class WebPageMessages {

	WebDriver driver;
	
	WebDriverWait wait;
	
	FluentWait<WebDriver> fwait;
	
	public static Logger log = Logger.getLogger(WebPageMessages.class);
	
	int flag =0; // 1-valid input 2-blank 3-invalid
	
	HashMap<String,String> logindata;
		
	public WebPageMessages(WebDriver driverinstance)
	{
			driver=driverinstance;
			PageFactory.initElements(driver,this);
			wait = new WebDriverWait(driver,30);
	}

	@FindBy(xpath = "//input")
	WebElement search;
	
	@FindBy(xpath = "//textarea")
	WebElement writemsg;
	
	@FindBy(xpath="//div[text()=\"Send\"]")
	WebElement sendbutton;
	
	@FindBy(xpath = "//div[@class=\"ml-10 mt-2\"]//span")
	WebElement changefocus;
	
	
	public boolean SearchandVerifyRecords() throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{			
			Thread.sleep(2000);
			changefocus.click();
			Thread.sleep(2000);
			search.clear();
			search.sendKeys("rupali jagtap");
			Thread.sleep(2000);
			
			List<WebElement> ele = driver.findElements(By.xpath("//tr//b"));
			
			for(WebElement element : ele)
			{
				if(element.getText().toLowerCase().contains("rupali jagtap"))
				{
					continue;
				}
				else
				{	log.info("Search records not matched as per search text");
					search.clear();
					return false;
				}
					
			}
			log.info("Search records matched as per search text");
			search.clear();
			return true;
		}
		catch (Exception e) {
			log.info("Caught Exception while Search And Verify Message ");
			Assert.fail("Search functionality not working, caught exception");
		}
		return false;
		
	}
	public boolean SendMessageandVerification() throws InterruptedException {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(2000);
			changefocus.click();
			Thread.sleep(2000);
			search.clear();
			search.sendKeys("rupali jagtap");
			Thread.sleep(2000);
			
			List<WebElement> ele = driver.findElements(By.xpath("//tr//b"));
			
			ele.get(0).click();
			
			Thread.sleep(3000);

			writemsg.sendKeys("Test Message");
			
			WebElement element = driver.findElements(By.xpath("//div[@class=\"mb-2\"]")).get(0);
			
			Thread.sleep(2000);
			sendbutton.click();
			
			int flag=0;
			Thread.sleep(2000);

			try
			{
				element.findElement(By.xpath("//img[@src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAICAYAAADA+m62AAAACXBIWXMAAAsTAAALEwEAmpwYAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAABuSURBVHgBpcq9CYAwEAXgd9FBHMEV3MAlxNJKbM9WGztBKyfJSnGAcHqNhIik8MH98hESGXgtdGYpJMgshE6jR89b+YUEdExjuxgveU0gG+IQzdyw/khbzzvfSyeQysC7GD0wxIC4GL2iWAt/cgEQgzWIZs4drQAAAABJRU5ErkJggg==\"]"));
				log.info("Message sent to Driver");
				flag++;

			}
			catch(NoSuchElementException e)
			{
				log.info("Single tick not occur looks message not sent");
			}
			Thread.sleep(2000);

			if(flag>0)
			{
				log.info("Sent Message functionality working");
				return true;
			}
			else
			{
				log.info("Send Message functionality not working");
				return false;
			}
			
		}
		catch (Exception e) {
			log.info("Caught Exception while sending message functionality");
			Assert.fail("Send message functionality not working, caught exception");
		}
		return false;
	}
	

}
