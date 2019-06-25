package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadDataFromExcel {
	
	public static void main(String[] args) throws IOException
	{
		String filepath=System.getProperty("user.dir")+"\\src";
		System.out.println(filepath);
		
		//create an object of file class to open xls file
		
		File file = new File(filepath+ "\\TestData.xlsx");
		
		//create an object of FileInutStream class to read excelfile
		FileInputStream fstream=new FileInputStream(file);
		
		//create object of XSSFWorkbookclass
		Workbook wb=new XSSFWorkbook(fstream);		
		
		//Read sheet inside the workbook by its name		
		Sheet sheet = wb.getSheet("DEMOsheet");
		
		//get rowcount of the particular sheet		
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		System.out.println(sheet.getLastRowNum()+" "+sheet.getFirstRowNum());
		
		for(int i=0;i<rowcount+1;i++)
		{
			Row row=sheet.getRow(i);
			
			for(int j=0;j<row.getLastCellNum();j++)
			{
				
				String value=row.getCell(j).getStringCellValue();
				
				System.out.print(value + "|| ");
			}
			
			System.out.println();
		}
		
		//wb.close();

		/// write data to excelsheet
		
		String[] valuetowrite={"user","march12","april12","gasdg"};
		
		//create a new row in the excel sheet
		Row newrow=sheet.createRow(rowcount+1);
		
		//Get the first row from excel sheet
		Row row=sheet.getRow(0);
		
		for(int k=0;k<row.getLastCellNum();k++)
		{
			Cell cell=newrow.createCell(k);
			cell.setCellValue(valuetowrite[k]);
			
		}
		
		fstream.close();
		
		FileOutputStream outputstream=new FileOutputStream(file);
		
		wb.write(outputstream);
		
		outputstream.close();
		
		wb.close();
		
	}

}
