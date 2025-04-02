package ddt_practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTByExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Campaign_Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String campaign=wb.getSheet("DDT").getRow(1).getCell(2).getStringCellValue();
		double targetSize=wb.getSheet("DDT").getRow(1).getCell(3).getNumericCellValue();
		System.out.println(campaign);
		System.out.println(targetSize);


	}

}
