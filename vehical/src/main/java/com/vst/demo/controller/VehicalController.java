package com.vst.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.demo.exception.VehicalException;
import com.vst.demo.model.Vehical;
import com.vst.demo.service.SequenceGeneratorService;
import com.vst.demo.service.VehicalServiceImpl;
import com.vst.demo.util.ExcelReader;

import jakarta.validation.Valid;

@RestController
public class VehicalController {

	private static final Logger logger = LogManager.getLogger(VehicalController.class);

	@Autowired
	VehicalServiceImpl vService;

	@Autowired
	SequenceGeneratorService sequenceService;
	
	
	@GetMapping("info")
	public  List<Vehical> getExcelData(){
		ExcelReader exr= new ExcelReader();
		return exr.vehicalTestReader();
		
	} 
	
//	@GetMapping("infos")
//	public List<Vehical> getExcelList(){
//	AnotherExcelReader excel = new AnotherExcelReader();
//	return excel.vehicalTestExcel();
//	}

	@PostMapping("vehical")
	public String saveVehicalDetail(@Valid @RequestBody Vehical vehical) {

		// for auto id update
		vehical.setId(sequenceService.getSequenceNumber(vehical.SEQUENCE_NAME));
		vehical.setActive(true);

		// to call the service for adding the data
		try {
			vService.saveVehicalDetailsService(vehical);
			return "Vehical Added Successfully";
		} catch (VehicalException e) {

			logger.error("Something Went Wrong, Please Check The Details You Entered");
			throw new VehicalException(e.getMessage());
		}
	}

	@DeleteMapping("vehical")
	public String deleteVehicalById(@RequestParam int id) {

		// call the service delete method for soft delete
		try {
			vService.deleteVehicalByIdService(id);

			return "vehical deleted";
		} catch (VehicalException e) {

			// if id is not correct it will throw the exception
			logger.error("Something Went Wrong, Please Check The Id");
			throw new VehicalException(e.getMessage());
		}
	}

	@PutMapping("vehical")
	public String UpdateVehical(@RequestParam("id") int id, @Valid @RequestBody Vehical vehical) {

		// call the service update method to manipulate the data
		try {
			vService.updateVehicalService(id, vehical);
			return "Vehical update successfully";
		} catch (VehicalException e) {

			logger.error("Something went wrong please check details");
			throw new VehicalException(e.getMessage());

		}

	}

	@GetMapping("vehical")
	public Vehical getDetailsById(@RequestParam("id") int id) {

		if (id > 0) {

			Vehical obj = vService.findVehicalByIdService(id);
			if (obj != null) {
				return obj;
			} else {

				throw new VehicalException("data doesn't exist");
			}
		} else {

			throw new VehicalException("please enter valid id");
		}
	}

	@GetMapping("vehicals") // read all details
	public List<Vehical> getAllDetails() {

		List list = vService.findVehicalListService();

		if (!list.isEmpty()) {
			return list;
		} else {

			throw new VehicalException("No data found");
		}

	}

	@GetMapping("vehicalRegistrationNo") // read details by registration no
	public Vehical getvehicalByRegistrationNo(@RequestParam("number") String number) {

		Vehical vh = vService.findVehicalByRegistrationNo(number);
		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");

	}

	@GetMapping("vehicalClass") // read details by vehical class
	public Vehical getVehicalByVehicalClass(@RequestParam("vclass") String vclass) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalClass(vclass);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("vehicalCompany") // read details by vehical company
	public Vehical getVehicalByVehicalCompany(@RequestParam("company") String company) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalCompany(company);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("VehicalModel") // read details by model
	public Vehical getVehicalByVehicalModel(@RequestParam("model") String model) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalModel(model);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("VehicalBattryType") // read details by battry type
	public Vehical getVehicalByVehicalBattryType(@RequestParam("type") String type) {

		Vehical vh = (Vehical) vService.findVehicalByBattryType(type);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("VehicalBattryCapacity") // read details by battry capacity
	public Vehical getVehicalByVehicalBattryCapacity(@RequestParam("capacity") String capacity) {

		Vehical vh = (Vehical) vService.findVehicalByBattryCapacity(capacity);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("VehicalAdaptorType") // read details by adaptor type
	public Vehical getVehicalByVehicalAdaptorType(@RequestParam("atype") String atype) {

		Vehical vh = (Vehical) vService.findVehicalByAdaptorType(atype);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	@GetMapping("VehicalOwnerUID") // read details by owner UID
	public Vehical getVehicalByVehicalOwnerUID(@RequestParam("UID") String UID) {

		Vehical vh = (Vehical) vService.findVehicalByOwnerUID(UID);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}
	
	@GetMapping("multiple")
	public boolean saveMultiple() {
		
		
		for(int i=1; i<10000; i++) {
			Vehical vehical = new Vehical();
			
			vehical.setVehicalRegistrationNo("MH23RF6543" + i);
			vehical.setVehicalClass("SUV"+i);
			vehical.setVehicalCompany("TATA"+i);
			vehical.setVehicalModel("nexon"+i);
			vehical.setVehicalColour("white"+i);
			vehical.setVehicalBattryType("Lithium-ion"+i);
			vehical.setVehicalBattryCapacity("30.2kWh"+i);
			vehical.setVehicalBattryWarranty("5years"+i);
			vehical.setVehicalAdaptorType("CSS2"+i);
			vehical.setVehicalTimeToCharge("9 Hour"+i);
			vehical.setVehicalPowerOutlet("front"+i);
			vehical.setVehicalChargeRange("60km"+i);
			vehical.setVehicalOwnerName("nikita"+i);
			vehical.setVehicalOwnerUID("243578765432"+i);
			vehical.setVehicalOwnerContactDetails("8765432345"+i);
			vehical.setVehicalOwnerAddress("Nagpur"+i);
			saveVehicalDetail(vehical);
			
		}
		return true;
		
		
	}

}
