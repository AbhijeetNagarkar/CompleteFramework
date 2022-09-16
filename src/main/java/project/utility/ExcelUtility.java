package project.utility;

import static project.constants.GlobalDeclaration.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
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
	
	public void configureInputExcel() throws IOException
	{
		inputifs = new FileInputStream(new File(InputExcelFile));
	}

	
	public void Inputfetchsheet(String sheetname)
	{
		sheetinput = inputworkbook.getSheet(sheetname);
		log.info("Fetching Input "+sheetname+" sheet from excel");
	}
	
	public void fetchdata()
	{
		for (int i = 0; i <= sheetinput.getLastRowNum(); i++) {
			
			for (int j = 0; j < sheetinput.getRow(i).getLastCellNum(); j++) {
				System.out.println(sheetinput.getRow(i).getCell(j));
			}
			
		}
		log.info("Fetched data from Excel");
	}
	public int numberOfRows()
	{
		return (sheetinput.getLastRowNum());
	}
	public int numberOfCols(int rowno)
	{
		return (sheetinput.getRow(rowno).getLastCellNum());
	}
	
	public void addloadingtimedata(HashMap<String,String> map) throws IOException
	{
		outputifs = new FileInputStream(new File(OutputExcelFile));
		
		outputworkbook = new XSSFWorkbook(outputifs);
		
		sheetoutput = outputworkbook.getSheet("LoadTime");
		
		outputofs = new FileOutputStream(new File(OutputExcelFile));
		
		log.info("Fetching excel data to update tracker file");
		
		try
		{
			int temp=sheetoutput.getRow(0).getLastCellNum();
			int flag=0;
			int lastrow=sheetoutput.getLastRowNum()+1;
			Date d = new Date(); 
			String dateWithoutTime = d.toString().substring(3,10);
			
			sheetoutput.getRow(0).createCell(temp,CellType.STRING).setCellValue(dateWithoutTime);
						
			for(String key : map.keySet())
			{
					for (int start = 0; start < lastrow; start++) 
					{
						flag=0;
						String str = sheetoutput.getRow(start).getCell(0).toString();
						if(str.equals(key))
						{
							sheetoutput.getRow(start).createCell(temp,CellType.NUMERIC).setCellValue(Integer.valueOf(map.get(key)));
							flag=1;
							log.info("Updating "+key+ " Page time");
							break;
						}
					}
					if(flag==0)
					{
					
							XSSFRow last = sheetoutput.createRow(lastrow);
							XSSFCell cell1 = last.createCell(0);
							XSSFCell cell2 = last.createCell(temp);
							cell1.setCellType(CellType.STRING);
							cell2.setCellType(CellType.NUMERIC);
							cell1.setCellValue(key);
							cell2.setCellValue(Integer.valueOf(map.get(key)));
							lastrow=lastrow+1;
							log.info("Updating "+key+ " Page time");
					}
			}
			
			outputworkbook.write(outputofs);
			outputworkbook.close();
			outputifs.close();
			outputofs.close();
			log.info("Tracker for Page Time Load saved");
		}
		catch(Exception e)
		{
			outputworkbook.close();
			outputifs.close();
			outputofs.close();
			log.info(e.getMessage());
		}
		
	}
}
