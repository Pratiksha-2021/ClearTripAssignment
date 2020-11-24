package com.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadDataFromExcel {
	
	
	//Excel Utility
		public static DataFormatter formatter = new DataFormatter();
		public static WebDriver driver;
		public static XSSFWorkbook wb;
		public static XSSFSheet sh;
		public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/resources/testData/excelSheet_DP.xlsx";
				
	

		public static Object[][] getTestData() throws Exception {
			System.out.println(">>>"+TESTDATA_SHEET_PATH);
			FileInputStream fis = new FileInputStream(TESTDATA_SHEET_PATH);
			
			System.out.println("initialisation of excelsheet");
			wb = new XSSFWorkbook(fis);
			sh = wb.getSheet("Sheet1");
			XSSFRow row = sh.getRow(0);
			int rowcount = sh.getPhysicalNumberOfRows();
			int lastcol = row.getLastCellNum();
			Object Data[][] = new Object[rowcount - 1][lastcol];

			System.out.println("total row count>>" + rowcount);
			System.out.println("total col count>>" + lastcol);
			for (int i = 0; i < rowcount - 1; i++) {
				XSSFRow row1 = sh.getRow(i + 1);
				for (int j = 0; j < lastcol; j++) {
					if (row1 == null)
						Data[i][j] = " ";
					else {
						XSSFCell cell = row1.getCell(j);
						System.out.println("cell value>>" + cell);
						if (cell == null)
							Data[i][j] = " ";
						else {
							String value = formatter.formatCellValue(cell);
							Data[i][j] = value;
						}
					}
				}
			}
			return Data;
		};

	

		

}
