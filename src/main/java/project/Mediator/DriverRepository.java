package project.Mediator;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class DriverRepository {

	    private static ThreadLocal<AndroidDriver> AndroiddriverInstance = new ThreadLocal<AndroidDriver>();

	    private static ThreadLocal<WebDriver> WebdriverInstance = new ThreadLocal<WebDriver>();
	    
	    public static AndroidDriver GetAndroidDriver() {
	        
	        return AndroiddriverInstance.get();
	    }

	    //Android driver setter
	    public static void SetAndroidDriver(AndroidDriver driver) {
	    	
	    	AndroiddriverInstance.set(driver);
	    }
	    
	    public static WebDriver GetWebDriver() {
	        return WebdriverInstance.get();
	    }
	    
	    
	    //Webdriver setter 
	    public static void SetWebDriver(WebDriver driver) {
	    	WebdriverInstance.set(driver);
	    }
	    
	    
	    public static void Refresh()
	    {
	    	WebdriverInstance.get().navigate().refresh();
	    }
	
}
