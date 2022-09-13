package project.constants;

import java.io.File;

public class GlobalDeclaration {
	
	public static final String USERNAME = "demo@truckx.com";

	public static final String lOGINPASSWORD = "Abcd1234";
	
	public static final String SENDEMAIL = "no";
	
	public static final String ExtendReportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator + "Extent_Results.html";
		
	public static final String log4jPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
									 File.separator+"java"+File.separator+"project"+File.separator+"config"+File.separator+"log4j.properties";
	
	public static final String RunConfigPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
										 File.separator+"java"+File.separator+"project"+File.separator+"config"+File.separator+"RunConfig.properties";

	public static final String ExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"input.xlsx";
}
