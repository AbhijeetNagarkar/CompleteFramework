package project.APIConfiguration;

public class RequestBody {
	
	static String body;
	
	public static void initBody()
	{
		body="";
	}
	public static void AddBody(String bodypart)
	{
		body = bodypart;
	}
	
	public static String GETBody()
	{
		return body;
	}


}
