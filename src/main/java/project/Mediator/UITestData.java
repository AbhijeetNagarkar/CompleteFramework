package project.Mediator;

import java.util.HashMap;

public class UITestData {
	
	//Excel sheet wise data objects to store test data for test scripts
	 private static ThreadLocal<HashMap<String,String>> logindata = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> Configurationdata = new ThreadLocal<HashMap<String,String>>();

	 //Login Excel sheet data
	 public static void SetLoginData(HashMap<String,String> data) 
	 {
			logindata.set(data);
	 }
	 public static HashMap<String, String> GetLoginData() 
	 {
			return logindata.get();
	 }
	 
	 //Configuration Excel sheet data
	 public static void SetConfigurationData(HashMap<String,String> data) 
	 {
		 	Configurationdata.set(data);
	 }
	 public static HashMap<String, String> GetConfigurationData() 
	 {
			return Configurationdata.get();
	 }

}
