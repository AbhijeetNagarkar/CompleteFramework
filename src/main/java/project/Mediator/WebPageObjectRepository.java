package project.Mediator;

import org.apache.log4j.Logger;
import project.WebPages.*;

public class WebPageObjectRepository {

	public static Logger log = Logger.getLogger(WebPageObjectRepository.class);
	
	public static ThreadLocal<WebPageLogin> WebLoginPage = new ThreadLocal<WebPageLogin>();

	public static WebPageLogin WebLoginPageObject()
		{
			if(WebLoginPage.get()==null)
			{
				WebLoginPage.set(new WebPageLogin(DriverRepository.GetWebDriver()));
				log.info("Web Login page object created");
			}
			return WebLoginPage.get();
		}
}
