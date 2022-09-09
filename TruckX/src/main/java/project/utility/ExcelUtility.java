package project.utility;

import static project.constants.GlobalDeclaration.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	XSSFWorkbook workbook;
	FileInputStream fs;
	XSSFSheet sheet;
	
	public void configureExcel() throws IOException
	{
		 fs = new FileInputStream(new File(ExcelFile));
		//Creating a workbook
		 workbook = new XSSFWorkbook(fs);
		
	}
	public void fetchsheet(String sheetname)
	{
		sheet = workbook.getSheet(sheetname);
	}
	public void fetchdata()
	{
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				System.out.println(sheet.getRow(i).getCell(j));
			}
			
		}
	}
	public int numberOfRows()
	{
		return (sheet.getLastRowNum());
	}
	public int numberOfCols(int rowno)
	{
		return (sheet.getRow(rowno).getLastCellNum());
	}
}
