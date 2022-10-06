package project.utility;

import java.util.HashMap;

public class TestData {

	 public static ThreadLocal<HashMap<String,String>> vehicledata = new ThreadLocal<HashMap<String,String>>();

	    public static HashMap<String,String> GetVehicleData() {
	        return vehicledata.get();
	    }

	    public static void SetVehicleData(HashMap<String,String> data) {
	    	vehicledata.set(data);
	    }
}
