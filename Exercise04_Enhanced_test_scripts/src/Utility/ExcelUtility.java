package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static  XSSFWorkbook wb;
	private static Sheet sheet;
	private static Cell cell;
	
	
	public static void setExcelFile() throws IOException
	{
		File file = new File("/Users/Priya/Desktop/workspace/Exercise04_Enhanced_test_scripts/LoginOperation.xlsx");
		FileInputStream istream=new FileInputStream(file);
		wb=new XSSFWorkbook(istream);
		sheet = wb.getSheet("Sheet1");
	
	}
	
	public static String getCellValue(int rownumber,int coulumnnumber)
	{
	   cell=sheet.getRow(rownumber).getCell(coulumnnumber);
	   String celldata=cell.getStringCellValue();
	   return celldata;
				
	}
	}


