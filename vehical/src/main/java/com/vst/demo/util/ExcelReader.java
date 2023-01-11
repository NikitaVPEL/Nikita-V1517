package com.vst.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vst.demo.model.Vehical;

public class ExcelReader {

	private static Logger logger = LogManager.getLogger(ExcelReader.class);

	// private static final String FILE_NAME =
	// "D:/Projects/vehical/vehicalTestList.xlsx";

	public List<Vehical> vehicalTestReader() {

		List<Vehical> vehicalList = new ArrayList<Vehical>();
		

//		Vehical vehical = new Vehical();

		File obj1 = new File("D:/projects/vehical/v.xlsx");
		try {
			obj1.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	//	"D:/Projects/vehical/vehicalTestList.xlsx"

		FileInputStream fis = null;

		try {
			fis = new FileInputStream("D:/projects/vehical/v.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();

		}

		Sheet sheet = workbook.getSheet("Sheet1");

		Iterator<Row> rows = sheet.iterator();
		rows.next();
		while (rows.hasNext()) {
System.out.println("executed");
			Row row = rows.next();
System.out.println(row);
			Iterator<Cell> cells = row.cellIterator();
			
			while (cells.hasNext()) {
				System.out.println("executed cells");
				int id = 100;
						id++;

				Cell cell = cells.next();
				System.out.println("executed cells i");
				String vehicalRegistrationNo = cell.getStringCellValue();
				System.out.println(vehicalRegistrationNo);
				System.out.println("executed cells ii");

				cell = cells.next();
				String vehicalClass = cell.getStringCellValue();
				System.out.println(vehicalClass);

				cell = cells.next();
				String vehicalCompany = cell.getStringCellValue();
				System.out.println(vehicalCompany);

				cell = cells.next();
				String vehicalModel = cell.getStringCellValue();
				System.out.println(vehicalModel);

				cell = cells.next();
				String vehicalColour = cell.getStringCellValue();
				System.out.println(vehicalColour);

				cell = cells.next();
				String vehicalBattryType = cell.getStringCellValue();
				System.out.println(vehicalBattryType);

				cell = cells.next();
				String vehicalBattryCapacity = cell.getStringCellValue();
				System.out.println(vehicalBattryCapacity);

				cell = cells.next();
				String vehicalBattryWarranty = cell.getStringCellValue();
				System.out.println(vehicalBattryWarranty);

				cell = cells.next();
				String vehicalAdaptorType = cell.getStringCellValue();
				System.out.println(vehicalAdaptorType);

				cell = cells.next();
				String vehicalTimeToCharge = cell.getStringCellValue();
				System.out.println(vehicalTimeToCharge);

				cell = cells.next();
				String vehicalPowerOutlet = cell.getStringCellValue();
				System.out.println(vehicalPowerOutlet);

				cell = cells.next();
				String vehicalChargeRange = cell.getStringCellValue();
				System.out.println(vehicalChargeRange);

				cell = cells.next();
				String vehicalOwnerName = cell.getStringCellValue();
				System.out.println(vehicalOwnerName);

				cell = cells.next();
				String vehicalOwnerUID = cell.getStringCellValue();
				System.out.println(vehicalOwnerUID);

				cell = cells.next();
				String vehicalOwnerContactDetails = cell.getStringCellValue();
				System.out.println(vehicalOwnerContactDetails);

				cell = cells.next();
				String vehicalOwnerAddress = cell.getStringCellValue();
				System.out.println(vehicalOwnerAddress);

//		 cell =cells.next();
//		 boolean isActive =  (boolean) cell.getBooleanCellValue();
//		 System.out.println(isActive);
//				Vehical vehical =new Vehical();
//		 vehical.setId(1);
//		 vehical.setVehicalRegistrationNo(vehicalRegistrationNo);
//		 vehical.setVehicalClass(vehicalClass);
//		 vehical.setVehicalCompany(vehicalCompany);
//		 vehical.setVehicalModel(vehicalModel);
//		 vehical.setVehicalColour(vehicalColour);
//		 vehical.setVehicalBattryType(vehicalBattryType);
//		 vehical.setVehicalBattryCapacity(vehicalBattryCapacity);
//		 vehical.setVehicalBattryWarranty(vehicalBattryWarranty);
//		 vehical.setVehicalAdaptorType(vehicalAdaptorType);
//		 vehical.setVehicalTimeToCharge(vehicalTimeToCharge);
//		 vehical.setVehicalPowerOutlet(vehicalPowerOutlet);
//		 vehical.setVehicalChargeRange(vehicalChargeRange);
//		 vehical.setVehicalOwnerName(vehicalOwnerName);
//		 vehical.setVehicalOwnerUID(vehicalOwnerUID);
//		 vehical.setVehicalOwnerContactDetails(vehicalOwnerContactDetails);
//		 vehical.setVehicalOwnerAddress(vehicalOwnerAddress);
//		 System.out.println(vehical);
//		 Vehical v=new Vehical(id,vehicalRegistrationNo,vehicalClass,vehicalCompany,vehicalModel,vehicalColour,vehicalBattryType,vehicalBattryCapacity,vehicalBattryWarranty,vehicalAdaptorType,vehicalTimeToCharge,vehicalPowerOutlet,vehicalChargeRange,vehicalOwnerName,vehicalOwnerUID,vehicalOwnerContactDetails,vehicalOwnerAddress,true);
				// System.out.println(v);
				Vehical vehical=new Vehical(id, vehicalRegistrationNo, vehicalClass, vehicalCompany, vehicalModel,
						vehicalColour, vehicalBattryType, vehicalBattryCapacity, vehicalBattryWarranty,
						vehicalAdaptorType, vehicalTimeToCharge, vehicalPowerOutlet, vehicalChargeRange,
						vehicalOwnerName, vehicalOwnerUID, vehicalOwnerContactDetails, vehicalOwnerAddress, true);
				
//				System.out.println(vehical);
				vehicalList.add(vehical);
				System.out.println(vehicalList);
				
//				vehicalList.add(new Vehical(id, vehicalRegistrationNo, vehicalClass, vehicalCompany, vehicalModel,
//						vehicalColour, vehicalBattryType, vehicalBattryCapacity, vehicalBattryWarranty,
//						vehicalAdaptorType, vehicalTimeToCharge, vehicalPowerOutlet, vehicalChargeRange,
//						vehicalOwnerName, vehicalOwnerUID, vehicalOwnerContactDetails, vehicalOwnerAddress, true));

			}

		}
		
		System.out.println(vehicalList);
		return vehicalList;

	}

}
