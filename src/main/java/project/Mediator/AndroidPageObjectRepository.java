package project.Mediator;

import org.apache.log4j.Logger;

import project.MobilePages.LogbookLogin;

public class AndroidPageObjectRepository 
{
	
	public static Logger log = Logger.getLogger(AndroidPageObjectRepository.class);
	
	public static ThreadLocal<LogbookLogin> loginScreen = new ThreadLocal<LogbookLogin>();

    public static LogbookLogin LogbookLogin() 
    {
    		if(loginScreen.get()==null)
    		{
    			loginScreen.set(new LogbookLogin(DriverRepository.GetAndroidDriver()));
    			log.info("Login page object created");
    		}
    		return loginScreen.get();
    }

}
