package project.APIConfiguration;

import java.util.HashMap;

import project.Mediator.APITestData;

public class PathParameters {
	
	static HashMap<String,String> pathParam;
	
	public static void initPathParameter()
	{
		pathParam = new HashMap<>();
	}
	
	public static void AddPathParameter(String key)
	{
		if(URL.APIurl.equalsIgnoreCase("https://api-gateway.truckx.com/"))
			pathParam.put(key, APITestData.GetProdTestData().get(key));
		else
			pathParam.put(key, APITestData.GetStageTestData().get(key));
	}
	
	public static HashMap<String,String> GETPathParameters()
	{
		return pathParam;
	}
}
