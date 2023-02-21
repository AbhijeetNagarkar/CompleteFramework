package project.constants;

import java.io.File;

public class ConstantDeclaration {
	
	public static final String ExtendReportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator + "Extent_Results.html";
		
	public static final String log4jPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
									 File.separator+"java"+File.separator+"project"+File.separator+"logger"+File.separator+"log4j.properties";
	
	public static final String MobileInputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"Mobileinput.xlsx";
	
	public static final String UIInputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"UIinput.xlsx";
	
	public static final String APIInputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"APIinput.xlsx";
	
	public static final String LOCALENVIRONMENT = "Local";
	
	public static final String JENKINSENVIRONMENT = "Jenkins";
}
