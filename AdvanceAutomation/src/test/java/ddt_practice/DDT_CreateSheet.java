package ddt_practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_CreateSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Campaign_Test.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("WriteData");
		sh.createRow(1).createCell(3).setCellValue("abc");
		FileOutputStream fout=new FileOutputStream(".\\src\\test\\resources\\Campaign_Test.xlsx");
		wb.write(fout);
		wb.close();
		System.out.println("file written");
	}

}
