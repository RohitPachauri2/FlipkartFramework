package Stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Baseclass.libarrayclass;

public class Excelfleread extends libarrayclass {

	public String Excelfleread(String sheetname, int rownumber, int cellnumber) throws IOException {
		// TODO Auto-generated constructor stub
		File file = new File("C:\\Users\\PC\\git\\Flipkart\\FlipkartAutomation\\Test Data\\searchtextdetails.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook xf = new XSSFWorkbook(fis);
		Sheet sh = xf.getSheet(sheetname);

		Row row = sh.getRow(rownumber);
		Cell cell = row.getCell(cellnumber);
		return cell.getStringCellValue();

	}

	public void excelwrite(String sheetname, int rownumber, int cellnumber, String text) throws IOException {

		File file1 = new File("C:\\Users\\PC\\git\\Flipkart\\FlipkartAutomation\\Test Data\\searchtextdetails.xlsx");
		FileInputStream fis = new FileInputStream(file1);
		Workbook xf = new XSSFWorkbook(fis);
		Sheet sh = xf.getSheet(sheetname);
		Row row = sh.getRow(rownumber);
		Cell cell = row.createCell(cellnumber);
		cell.setCellValue(text);
		FileOutputStream fos = new FileOutputStream(file1);
		xf.write(fos);

	}

}
