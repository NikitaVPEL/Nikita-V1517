package com.vst.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Assertions;
import com.vst.demo.excelReader.ExcelReaderClass;
import com.vst.demo.model.Vehical;
import com.vst.demo.service.VehicalServiceImpl;
import com.vst.demo.util.ExcelReader;

@SpringBootTest
class VehicalApplicationTests {
	
	@Autowired
	VehicalServiceImpl vehicalService;

	@Test
	void contextLoads() {
	
//		ExcelReader excelReader = new ExcelReader();
//		
//		List<Vehical> vehical = excelReader.vehicalTestReader();
//		
//		for (int i = 0; i < vehical.size(); i++) {
//
//			Assertions.assertEquals(true, vehicalService.saveVehicalDetailsService(vehical.get(i)));
//			
			
//			AnotherExcelReader excelReaders = new AnotherExcelReader();
//			
//			List<Vehical> vehical = excelReaders.vehicalTestExcel();
//			
//			for (int i = 0; i < vehical.size(); i++) {
//
//				Assertions.assertEquals(true, vehicalService.saveVehicalDetailsService(vehical.get(i)));
//		}
		
		
	}

}
