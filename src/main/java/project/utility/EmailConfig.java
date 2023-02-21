package project.utility;

public class EmailConfig {
	
	public static final String SERVER = "smtp.gmail.com";
    
	public static final String PORT = "465";
    
	public static final String[] TO = {"abhijeet@truckx.com","abhijeet.nagarkar@coditas.com"};
    
	public static String SUBJECT = "Logbook App - Automation Report";

	public static final String LOCALFROM = System.getenv().get("LOGBOOKAUTOEMAIL");
	
	public static final String LOCALPASSWORD = System.getenv().get("LOGBOOKAUTOEMAILPASSWORD"); 
	
	public static final String CLOUDFROM = System.getProperty("LOGBOOKAUTOEMAIL");
	
	public static final String CLOUDPASSWORD = System.getProperty("LOGBOOKAUTOEMAILPASSWORD"); 
	
	public static String SendEmail = "No";
	
}
