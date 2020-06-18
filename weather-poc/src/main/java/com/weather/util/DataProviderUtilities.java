package com.weather.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\mithilaa\\eclipse-workspace\\myworkspace\\weather-poc\\src\\main\\java\\com\\weather\\testdata\\Locations.xlsx";	
	public static Workbook book;
	public static Sheet sheet;
	
	@DataProvider
	public static Object[][] getCityNamesFromExcel(String sheetName)
	{
		FileInputStream fp = null;
		try {
			fp = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fp);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum();i++){
			for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;		
	}
}
