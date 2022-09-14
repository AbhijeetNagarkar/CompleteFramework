package project.utility;

import org.openqa.selenium.WebDriver;

public class Driver {

	    public static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

	    public static WebDriver GetDriver() {
	        return driverInstance.get();
	    }

	    public static void SetDriver(WebDriver driver) {
	        driverInstance.set(driver);
	    }
	
}
