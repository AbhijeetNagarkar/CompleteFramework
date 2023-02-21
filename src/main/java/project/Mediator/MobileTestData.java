package project.Mediator;

import java.util.HashMap;

public class MobileTestData 
{
	//Excel sheet wise data objects to store test data for test scripts
	 private static ThreadLocal<HashMap<String,String>> configurationdata = new ThreadLocal<HashMap<String,String>>();	 
	 
	 public static void SetConfigurationData(HashMap<String,String> data) 
	 {
			configurationdata.set(data);
	 }
	 public static HashMap<String, String> GetConfigurationData() 
	 {
			return configurationdata.get();
	 }
	
}
