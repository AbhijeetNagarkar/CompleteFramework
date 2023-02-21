package project.APIConfiguration;

import java.util.HashMap;

import project.Mediator.APITestData;

public class QueryParameters {

	static HashMap<String,String> queryParam;
	
	public static void initQueryParameter()
	{
		queryParam = new HashMap<>();
	}
	
	
	public static void AddQueryParameter(String key)
	{
		String requestkey;
		switch(key)
		{
			case "Elogs start" : requestkey="start";
								break;
							
			case "Elogs limit" : requestkey="limit";
								break;
			 
			case "Truck Location start_date" : requestkey="start_date";
								break;
			 
			case "Truck Location end_date" : requestkey="end_date";
								break;
							
			case "Truck Location userId" : requestkey="userId";
								break;
								
			case "IFTA start_date" : requestkey="start_date";
			break;

			case "IFTA end_date" : requestkey="end_date";
			break;

			case "IFTA truck_uuid" : requestkey="truck_uuid";
			break;

			case "IFTA userId" : requestkey="userId";
			break;
								
			case "Gallons start_date" : requestkey="start_date";
			break;

			case "Gallons end_date" : requestkey="end_date";
			break;

			case "Gallons truck_uuid" : requestkey="truck_uuid";
			break;

			case "Gallons userId" : requestkey="userId";
			break;

			
			default : requestkey = key;
		}
			
		if(URL.APIurl.equalsIgnoreCase("https://api-gateway.truckx.com/"))
			queryParam.put(requestkey, APITestData.GetProdTestData().get(key));
		else
			queryParam.put(requestkey, APITestData.GetStageTestData().get(key));
		
//  		System.out.println(queryParam.toString());
	}
	
	public static HashMap<String,String> GETQueryParameters()
	{
		return queryParam;
	}

}
