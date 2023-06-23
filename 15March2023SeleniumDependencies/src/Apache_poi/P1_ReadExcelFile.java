package Apache_poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
*@Author -- Aditya Shinde Java + Selenium 
* 22-Jun-2023
* 3:26:08 pm
**/
public class P1_ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File path = new File(".\\datafiles\\Test.xlsx");
		
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		String data = sheet.getRow(4).getCell(0).getStringCellValue();
		System.out.println(data);
		
		double data1 = sheet.getRow(4).getCell(4).getNumericCellValue();
		int num = (int)data1;
		System.out.println(data1);
		
		String sd = String.valueOf(num);
		System.out.println(sd);
		
	}

}
