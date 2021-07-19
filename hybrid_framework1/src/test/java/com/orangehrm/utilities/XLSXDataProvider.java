package com.orangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXDataProvider {
	
	 XSSFWorkbook wb;

	public XLSXDataProvider()
	{
		try
		{
			
		File fs =	new File("./Testdata/Testdata.xlsx");	
			FileInputStream fis=new FileInputStream(fs);
			 wb= new XSSFWorkbook(fis);
		
		}
		catch(Exception e)
		{
			System.out.println("xlfile not found>>"+e.getMessage());
		}
	}

	public String  getcellstringdata(String sheetname,int row,int column )
	{
	return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	
	}
	
	public int getnumericcelldata(String sheetname,int row, int column)

{
		return (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
				
}
	public String  getcellstringdata(int sheetindexname,int row,int column )
	{
	return wb.getSheetAt(sheetindexname).getRow(row).getCell(column).getStringCellValue();
	
	}
	
	public int getnumericcelldata(int sheetindexname,int row, int column)

{
		return (int) wb.getSheetAt(sheetindexname).getRow(row).getCell(column).getNumericCellValue();
				
}
	
	public Object[][] exceltestdata(String sheetname)
	
	{
		XSSFSheet sheet= wb.getSheet(sheetname);
		
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		
		Object data[][]=new Object[rowcount][colcount];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data [i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
	
	
	
	
}
