package com.Datatable;

import java.io.FileInputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class DataExcel {
	public static int Row_Count(String FileName, String SheetName)
	{
		FileInputStream fin = null;
		Workbook wb = null;
		Sheet sh = null;
		int rc = 0;
		
		try{
		fin = new FileInputStream(FileName);
		wb = new HSSFWorkbook(fin);
		sh = wb.getSheet(SheetName);
		if(sh == null)
		{
			return -1;
		}
		rc = sh.getPhysicalNumberOfRows();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rc;
	}
	
	
	public static String getCellData(String FileName, String SheetName, String ColName, int rownum)
	{
		String sData = null;
		FileInputStream fin = null;
		Workbook wb = null;
		Sheet sh = null;
		Row row = null;
		Cell cell = null;
		int colnum =0;
		try
		{
			fin = new FileInputStream(FileName);
			wb =  new HSSFWorkbook(fin);;
			if(wb.getSheetIndex(SheetName)==-1)
			{
				return null;
			}
			sh = wb.getSheet(SheetName);
			row = sh.getRow(0);
			for(int ch = 0 ; ch<row.getLastCellNum(); ch++)
			{
				cell = row.getCell(ch);
				String val = cell.getStringCellValue();
				if(val.trim().equalsIgnoreCase(ColName))
				{
					colnum = ch;
				}
			}
			
			row = sh.getRow(rownum);
			cell = row.getCell(colnum);
			if(cell ==null || cell.getCellType() == cell.CELL_TYPE_BLANK)
			{
				sData =  "";
			}
			else if(cell.getCellType() == cell.CELL_TYPE_STRING)
			{
				sData = cell.getStringCellValue();
			}
			else if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN)
			{
				sData = String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC || cell.getCellType() == cell.CELL_TYPE_FORMULA)
			{
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					double val = cell.getNumericCellValue();
					Calendar cl = Calendar.getInstance();
					cl.setTime(HSSFDateUtil.getJavaDate(val));
					sData = String.valueOf(cl.get(Calendar.MONTH)+1)+"/"+cl.get(Calendar.DAY_OF_MONTH)+"/"+cl.get(Calendar.YEAR);
				}else
				{
					sData = String.valueOf(cell.getNumericCellValue());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
				sh = null;
				row = null;
				cell = null;
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return sData;
	}
}
