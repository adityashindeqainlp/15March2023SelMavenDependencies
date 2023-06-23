package Apache_poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author -- Aditya Shinde Java + Selenium 22-Jun-2023 3:46:10 pm
 **/
public class P2_ExcelWrite {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File path = new File(".\\datafiles\\Test.xlsx");

		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		FileOutputStream fos = new FileOutputStream(path);

		sheet.createRow(7).createCell(0).setCellValue("Tom");

		workbook.write(fos);

	}

}
