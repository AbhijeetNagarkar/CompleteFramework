package project.utility;

import static project.constants.ConstantDeclaration.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.log4j.Logger;

public class ExcelUtility {

	XSSFWorkbook inputworkbook;
	XSSFWorkbook outputworkbook;
	FileInputStream inputifs;
	FileOutputStream inputofs;
	FileInputStream outputifs;
	FileOutputStream outputofs;
	XSSFSheet sheetinput;
	XSSFSheet sheetoutput;
	
	public static Logger log = Logger.getLogger(ExcelUtility.class);
	
	public HashMap<String,String> fetchdata(String suitetype,String sheet) throws IOException
	{
		HashMap<String, String> map = new HashMap<>();
		

		if(suitetype.equalsIgnoreCase("Mobile"))
		{
			inputifs = new FileInputStream(new File(MobileInputExcelFile));
		}
		else if(suitetype.equalsIgnoreCase("API"))
		{
			inputifs = new FileInputStream(new File(APIInputExcelFile));
		}
		else if(suitetype.equalsIgnoreCase("UI"))
		{
			inputifs = new FileInputStream(new File(UIInputExcelFile));
		}
		
		inputworkbook = new XSSFWorkbook(inputifs);
		
		sheetinput = inputworkbook.getSheet(sheet);
		
		for (int i = 0; i <= sheetinput.getLastRowNum(); i++) 
		{
			String key = (sheetinput.getRow(i).getCell(0)).getStringCellValue();
			String val;
			try
			{
			 val = (sheetinput.getRow(i).getCell(1)).getStringCellValue();
			}
			catch (Exception e) {
				// TODO: handle exception
				val=String.valueOf((sheetinput.getRow(i).getCell(1)).getRawValue());
			}
			
			map.put(key,val);
		}
	
		return map;
	}
	
	public int numberOfRows()
	{
		return (sheetinput.getLastRowNum());
	}
	
	public int numberOfCols(int rowno)
	{
		return (sheetinput.getRow(rowno).getLastCellNum());
	}
	

}
