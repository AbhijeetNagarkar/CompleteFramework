package project.APIConfiguration;

import java.util.HashMap;

import project.Mediator.APITestData;


public class Headers {
	
	static HashMap<String,String> header;
	
	public static void initHeaders()
	{
		if(header==null)
		header = new HashMap<>();
		else
			header.clear();
	}
	

	public static void AddHeaders(String key)
	{
		String requestkey;
		switch(key)
		{
			case "IFTA TRUCKX-FMS-ID" : requestkey="TRUCKX-FMS-ID";
								break;
								
			case "Gallons TRUCKX-FMS-ID" : requestkey="TRUCKX-FMS-ID";
								break;
							
			default : requestkey = key;
		}
		if(URL.APIurl.equalsIgnoreCase("https://api-gateway.truckx.com/"))
			header.put(requestkey, APITestData.GetProdTestData().get(key));
		else
			header.put(requestkey, APITestData.GetStageTestData().get(key));
		
	//	System.out.println(header.toString());
		
	}
	
	public static HashMap<String,String> GETHeaders()
	{
		return header;
	}
	
}
