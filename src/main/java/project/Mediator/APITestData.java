package project.Mediator;

import java.util.HashMap;

public class APITestData {
	
		//Excel sheet wise data objects to store test data for test scripts
	 private static ThreadLocal<HashMap<String,String>> UserDetails = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> MailDetails = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> StageTestData = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> ProdTestData = new ThreadLocal<HashMap<String,String>>();

	 
	 public static HashMap<String,String> GetuserId()
	 {
	        return UserDetails.get();
	 }
	 public static void SetUserId(HashMap<String,String> data) 
	 {
	    	UserDetails.set(data);
	 }

	 
	 public static void SetMailDetails(HashMap<String, String> fetchdata) 
	 {
			MailDetails.set(fetchdata);
	 }
	 public static HashMap<String,String> GetMailDetails() 
	 {
	        return MailDetails.get();
	 }
	 
	 
	 public static HashMap<String,String> GetStageTestData()
	 {
	        return StageTestData.get();
	 }
	 public static void SetStageTestData(HashMap<String,String> data) 
	 {
		 StageTestData.set(data);
	 }
	 
	 
	 public static HashMap<String,String> GetProdTestData()
	 {
	        return ProdTestData.get();
	 }

	 public static void SetProdTestData(HashMap<String,String> data) 
	 {
		 ProdTestData.set(data);
	 }
}
