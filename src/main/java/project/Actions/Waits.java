package project.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.Mediator.DriverRepository;

public class Waits {

	static WebDriverWait mwait2,mwait5,mwait10;
	
	static WebDriverWait webwait2,webwait5,webwait10;


	//wait declaration for 2,5,10 seconds for Mobile Elements
	private static WebDriverWait MobileWaitDeclaration(WebDriver driver,int i) 
	{
		if(i==2)
		{
			if(mwait2==null)
				mwait2 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return mwait2;
		}
		if(i==5)
		{
			if(mwait5==null)
				mwait5 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return mwait5;
		}
		if(i==10)
		{
			if(mwait10==null)
				mwait10 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return mwait10;
		}
		return mwait2;
	}
	
	
	//wait declaration for 2,5,10 seconds for Web Elements
	private static WebDriverWait WebWaitDeclaration(WebDriver driver,int i) 
	{
		if(i==2)
		{
			if(webwait2==null)
				webwait2 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return webwait2;
		}
		if(i==5)
		{
			if(webwait5==null)
				webwait5 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return webwait5;
		}
		if(i==10)
		{
			if(webwait10==null)
				webwait10 = new WebDriverWait(driver, Duration.ofSeconds(i));
			return webwait10;
		}
		return webwait2;
	}
	
	//Generic wait with respect to seconds
	public static void Wait(int seconds) throws InterruptedException
	{
		Thread.sleep((seconds*1000));
	}

	//------------------------------------------------------------------------------//
	//Mobile elements wait below
	//wait until  visibility for WebElement by Element
	public static void ShortWaitForMobileElementVisibility(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),2);
		mwait2.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void NormalWaitForMobileElementVisibility(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),5);
		mwait5.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void LongWaitForMobileElementVisibility(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),10);
		mwait10.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	//wait until visibility of WebElement using locator
	public static void ShortWaitForMobileElementVisibility(By ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),2);
		mwait2.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	public static void NormalWaitForMobileElementVisibility(By ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),5);
		mwait5.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	public static void LongWaitForMobileElementVisibility(By ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),10);
		mwait10.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	
	//Wait to click on WebElement 
	public static void ShortWaitForMobileElementClick(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),2);
		mwait2.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void NormalWaitForMobileElementClick(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),5);
		mwait5.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void LongWaitForMobileElementClick(WebElement ele)
	{
		MobileWaitDeclaration(DriverRepository.GetAndroidDriver(),10);
		mwait10.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	//---------------------------------------------------------------------------------//
	
	//WebElements wait below
	
	//wait until  visibility for WebElement by Element
	public static void ShortWaitForWebElementVisibility(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),2);
		webwait2.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void NormalWaitForWebElementVisibility(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),5);
		webwait5.until(ExpectedConditions.visibilityOf(ele));
	}
	public static void LongWaitForWebElementVisibility(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),10);
		webwait10.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	//wait until visibility of WebElement using locator
	public static void ShortWaitForWebElementVisibility(By ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),2);
		webwait2.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	public static void NormalWaitForWebElementVisibility(By ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),5);
		webwait5.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	public static void LongWaitForWebElementVisibility(By ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),10);
		webwait10.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}
	
	
	//Wait to click on WebElement 
	public static void ShortWaitForWebElementClick(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),2);
		webwait2.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void NormalWaitForWebElementClick(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),5);
		webwait5.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void LongWaitForWebElementClick(WebElement ele)
	{
		WebWaitDeclaration(DriverRepository.GetWebDriver(),10);
		webwait10.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
