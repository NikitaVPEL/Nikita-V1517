//package com.vst.demo.util;
//
//
//	import java.io.FileInputStream;
//	import java.io.FileNotFoundException;
//	import java.io.IOException;
//	import java.util.ArrayList;
//	import java.util.Iterator;
//	import java.util.List;
//
//	import org.apache.poi.ss.usermodel.Cell;
//	import org.apache.poi.ss.usermodel.Row;
//	import org.apache.poi.ss.usermodel.Sheet;
//	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.vst.demo.model.Vehical;
//
//
//	public class AnotherExcelReader {
//
//	  public List < Vehical > vehicalTestExcel() {
//
//	    List < Vehical > vehicalList = new ArrayList < > ();
//
//	    Vehical vehicalData = new Vehical();
//
//	    FileInputStream fis = null;
//	    try {
//			 fis = new FileInputStream("D:/Projects/vehical/vehicalTestList.xlsx");
//	    } catch (FileNotFoundException e) {
//	      e.printStackTrace();
//	    }
//	    XSSFWorkbook workbook = null;
//	    try {
//	      workbook = new XSSFWorkbook(fis);
//	    } catch (IOException e) {
//	      e.printStackTrace();
//	    }
//	    Sheet sheet = workbook.getSheet("Sheet1");
//	    Iterator < Row > rows = sheet.iterator();
//	    rows.next();
//	    while (rows.hasNext()) {
//	      Row row = rows.next();
//	      Iterator < Cell > cells = row.cellIterator();
//	      while (cells.hasNext()) {
//	    	  
//	        Cell cell = cells.next();
//	        int id = Integer.parseInt(cell.getStringCellValue());
//
//	        cell = cells.next();
//			String vehicalRegistrationNo = cell.getStringCellValue();
//		System.out.println(vehicalRegistrationNo);
//
//			
//	        cell = cells.next();
//		    String vehicalClass = cell.getStringCellValue();
//		    
//	        cell = cells.next();
//			 String vehicalCompany = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalModel = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalColour = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalBattryType = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalBattryCapacity = cell.getStringCellValue();
//			 System.out.println(vehicalBattryCapacity);
//			 
//		        cell = cells.next();
//			 String vehicalBattryWarranty = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalAdaptorType = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalTimeToCharge = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalPowerOutlet = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalChargeRange = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalOwnerName = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalOwnerUID = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalOwnerContactDetails = cell.getStringCellValue();
//			 
//		        cell = cells.next();
//			 String vehicalOwnerAddress = cell.getStringCellValue();
//			 
//			 vehicalList.add(new Vehical(id,vehicalRegistrationNo,vehicalClass,vehicalCompany,vehicalModel,vehicalColour,vehicalBattryType,vehicalBattryCapacity,vehicalBattryWarranty,vehicalAdaptorType,vehicalTimeToCharge,vehicalPowerOutlet,vehicalChargeRange,vehicalOwnerName,vehicalOwnerUID,vehicalOwnerContactDetails,vehicalOwnerAddress,true));
//
//	      }
//
//	    }
//
//	    return vehicalList;
//	  }
//
//	}
//	
//
//
