package project.testscenarios;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import project.mediator.ObjectRepository;
import project.utility.WebPageObjectCreation;

public class APIKeyTransferScript {
	WebPageObjectCreation repo;
	
	public static Logger log = Logger.getLogger(AssetsScript.class);
	
	@BeforeClass
	public void Fetct_Repository_Object() throws InterruptedException, IOException
	{
		repo = ObjectRepository.GetInstance();
	}
	
}
