package project.mediator;

import java.util.HashMap;

public class TestData 
{

	 private static ThreadLocal<HashMap<String,String>> vehicledata = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> devicedata = new ThreadLocal<HashMap<String,String>>();

	 private static ThreadLocal<HashMap<String,String>> trailerdata = new ThreadLocal<HashMap<String,String>>();
	 
	 private static ThreadLocal<HashMap<String,String>> logindata = new ThreadLocal<HashMap<String,String>>();
	 
	 private static ThreadLocal<HashMap<String,String>> configurationdata = new ThreadLocal<HashMap<String,String>>();	 
	 
	 private static ThreadLocal<HashMap<String,String>> forgotpassworddata = new ThreadLocal<HashMap<String,String>>();
	 
	 private static ThreadLocal<HashMap<String, String>> adminregisterdata = new ThreadLocal<HashMap<String, String>>(); //Rupali
		 
	 private static ThreadLocal<HashMap<String,String>> companyprofiledata = new ThreadLocal<HashMap<String,String>>();
	 
	 private static ThreadLocal<HashMap<String,String>> driversdata = new ThreadLocal<HashMap<String,String>>();

	 	public static HashMap<String,String> GetDriversData() {
	        return driversdata.get();
	    }

	    public static void SetDriversData(HashMap<String,String> data) {
	    	driversdata.set(data);
	    }
	    public static HashMap<String,String> GetVehicleData() {
	        return vehicledata.get();
	    }

	    public static void SetVehicleData(HashMap<String,String> data) {
	    	vehicledata.set(data);
	    }
	    
	    public static HashMap<String,String> GetDeviceData() {
	        return devicedata.get();
	    }

	    public static void SetDeviceData(HashMap<String,String> data) {
	    	devicedata.set(data);
	    }

		public static void SetTrailerData(HashMap<String,String> data) {
			// TODO Auto-generated method stub
			trailerdata.set(data);
			
		}
		public static HashMap<String, String> GetTrailerData() {
			// TODO Auto-generated method stub
			return trailerdata.get();
		}
		public static void SetLoginData(HashMap<String,String> data) {
			// TODO Auto-generated method stub
			logindata.set(data);
			
		}
		public static HashMap<String, String> GetLoginData() {
			// TODO Auto-generated method stub
			return logindata.get();
		}
		public static void SetConfigurationData(HashMap<String,String> data) {
			// TODO Auto-generated method stub
			configurationdata.set(data);
			
		}
		public static HashMap<String, String> GetConfigurationData() {
			// TODO Auto-generated method stub
			return configurationdata.get();
		}
		public static void SetCompanyProfileData(HashMap<String, String> data) {
			// TODO Auto-generated method stub
			companyprofiledata.set(data);
		}
		public static HashMap<String, String> GetCompanyProfileData() {
			// TODO Auto-generated method stub
			return companyprofiledata.get();
		}
		public static HashMap<String,String> GetForgotPasswordData() {
	        return forgotpassworddata.get();
	    }
	    public static void SetForgotPasswordData(HashMap<String,String> data) {
	    	forgotpassworddata.set(data);
	    }
		
		public static HashMap<String, String> GetAdminRegistrationData(){
			return adminregisterdata.get();			
		}
		public static void SetAdminRegistrationData(HashMap<String, String> data) {
			adminregisterdata.set(data);

		}
}
