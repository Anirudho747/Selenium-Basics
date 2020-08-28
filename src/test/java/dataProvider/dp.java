package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class dp {

	public static WebDriver driver = null;
	static String path = System.getProperty("user.dir");
	
	
	public static Object[][] dataget(String remPath,String sName,int col) throws IOException, FileNotFoundException{
	
		
			FileInputStream fis = new FileInputStream(path+remPath);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sName);
			XSSFCell cell=null;
			
			int rc = sheet.getPhysicalNumberOfRows();
			System.out.println(rc);
			
			String [][]result = new String[rc][col];
			
			for(int i=1;i<rc;i++)
			{
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++)
				{
					cell = sheet.getRow(i).getCell(j);
					cell.setCellType(CellType.STRING);
					String cdata = cell.getStringCellValue();
					System.out.println(cdata);
					result[i-1][j] = cdata;
				}
			}
			
			
			return result;
	}

	public static void main(String[] args) throws IOException, FileNotFoundException{
		
		//datapro(finalPath,sheetName,col);
		caller();
	}
	
	
	public static void caller() throws IOException, FileNotFoundException
	{
		String finalPath = "/Excel/trial.xlsx";
		String sheetName = "First";
		int col = 7;
		dataput(finalPath,sheetName,col);
		Object[][] rslt = dataget(finalPath,sheetName,col);
		
	}
	
	public static void dataput(String remPath,String sName,int col) throws IOException, FileNotFoundException
	{
		FileInputStream fis = new FileInputStream(path+remPath);
		XSSFWorkbook wb     = new XSSFWorkbook(fis);
		XSSFSheet sheet     = wb.getSheet(sName);
		Cell cell=null;
		
		int rc = sheet.getPhysicalNumberOfRows();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rc);
			
		for(int j=0;j<row.getPhysicalNumberOfCells();j++)
		{
			cell = newRow.createCell(j);
			cell.setCellValue("Did it");
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(path+remPath);
		wb.write(fos);
		fos.close();
		wb.close();
	}

}
