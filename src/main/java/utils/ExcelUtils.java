package utils;

import java.io.FileInputStream;

import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtils {
	// TODO Auto-generated method stub
			private static Workbook workbook;
			private static Sheet sheet;
			public static void loadExcel (String filePath, String SheetName) throws IOException
			{
				FileInputStream file = new FileInputStream(filePath);
				workbook = new HSSFWorkbook(file);
				sheet = workbook.getSheet(SheetName);
				
			}
			
			public static String getCellData(int row,int col)
			{
				Cell cell = sheet.getRow(row).getCell(col);
				if(cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			}
				else if(cell.getCellType() == CellType.NUMERIC) {
				return String.valueOf((int) cell.getNumericCellValue());
					
					
				}
				
				return "";
			
			}
			
			public static int getRowCount() {
				return sheet.getPhysicalNumberOfRows();
			}
			
			public static void closeExcel() throws IOException {
				workbook.close();
			}

	
}
