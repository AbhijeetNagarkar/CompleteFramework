package project.constants;

import java.io.File;

public class SchemaDeclaration {
	
	public static final String ExtendReportPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"Extent_Results.html";
		
	public static final String log4jPath = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
									 File.separator+"java"+File.separator+"project"+File.separator+"logger"+File.separator+"log4j.properties";
	
	public static final String InputExcelFile=System.getProperty("user.dir")+File.separator+"ExcelInput"+File.separator+"input.xlsx";
	
	public static final File TruckListSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"TruckListSchema.json");

	public static final File DriversSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Drivers.json");

	public static final File DashboardSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Dashboard.json");

	public static final File ELogsSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Elogs.json");

	public static final File CarrierinfoSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Carrier-info.json");

	public static final File TailerslistSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Trailers-list.json");

	public static final File TruckLocationSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Truck-locations.json");

	public static final File ArchivedDriversSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Archived-drivers.json");

	public static final File DriversListSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Drivers-list.json");

	public static final File IFTAReportSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"IFTAReports.json");

	public static final File IFTASchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"IFTA.json");

	public static final File GallonsSchema= new File(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+
			 File.separator+"java"+File.separator+"project"+File.separator+"schemas"+File.separator+"Gallons.json");

	
}
