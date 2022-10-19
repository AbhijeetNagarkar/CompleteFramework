package project.mediator;

import org.openqa.selenium.WebDriver;

public class Driver {

	    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();

	    public static WebDriver GetDriver() {
	        return driverInstance.get();
	    }

	    public static void SetDriver(WebDriver driver) {
	        driverInstance.set(driver);
	    }
	    public static void Refresh()
	    {
	    	driverInstance.get().navigate().refresh();
	    }
	
}
