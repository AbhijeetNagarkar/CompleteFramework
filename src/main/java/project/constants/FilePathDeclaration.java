package project.constants;

import java.io.File;

public class FilePathDeclaration {
	
	public static final String ExtendReportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator + "Extent_Results.html";
		
	public static final String log4jPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
									 File.separator+"java"+File.separator+"project"+File.separator+"logger"+File.separator+"log4j.properties";
	
	public static final String RunConfigPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
										 File.separator+"java"+File.separator+"project"+File.separator+"config"+File.separator+"RunConfig.properties";

	public static final String InputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"input.xlsx";
	
	public static final String OutputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelOutput"+File.separator+"loadingtime.xlsx";
	
}
