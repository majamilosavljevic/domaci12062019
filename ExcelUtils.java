package domaci_12062019;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {
	private static XSSFWorkbook wb = null;
	private static XSSFSheet sheet = null;
	private static String excellPath;

	public static boolean setExcell(String path) {
		if (wb != null) {
			try {
				wb.close();
			} catch (Exception e) {
				System.out.println(e.toString());
				return false;
			}
		}
		File f = new File(path);
		try {
			FileInputStream fis = new FileInputStream(f);

			wb = new XSSFWorkbook(fis);
			excellPath = path;
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Lose otvaranje fajla!");
			return false;
		}
	}

	public static boolean setWorkSheet(int index) {
		try {
			sheet = wb.getSheetAt(index);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Lose otvaranje worksheeta!");
			return false;
		}
	}

	public static String getDataAt(int row, int column) {
		try {
			XSSFRow r = sheet.getRow(row);
			XSSFCell celija = r.getCell(column);
			return celija.toString();
		} catch (NullPointerException e) {
			System.out.println(e.toString());
			System.out.println("Nesto je null!");
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Doslo je do greske!");
		}
		return "";
	}

	public static boolean setDataAt(int row, int column, String data) {
		try {
			XSSFRow r = sheet.getRow(row);
			if (r == null) {
				r = sheet.createRow(row);
			}
			XSSFCell celija = r.getCell(column);
			if (celija == null) {
				celija = r.createCell(column);
			}
			celija.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(excellPath); //uvodjenje vrednosti koja je u celiji u fajl
			wb.write(fos);
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Doslo je do greske!");
			return false;
		}
	}

	public static int getRowNumber() {
		try {
			
			return sheet.getLastRowNum() + 1;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Doslo je do greske!");
			return -1;
		}
	}

	public static boolean closeExcell() {
		if (wb != null) {
			try {
				wb.close();
				wb = null;
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				wb = null;
				return false;
			}
		}
		return true;
	}

}