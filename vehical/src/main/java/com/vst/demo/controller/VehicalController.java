package com.vst.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.demo.Converter.VehicalConverter;
import com.vst.demo.dto.VehicalDTO;
import com.vst.demo.exception.VehicalException;
import com.vst.demo.model.Vehical;
import com.vst.demo.service.KafkaPublisher;
import com.vst.demo.service.SequenceGeneratorService;
import com.vst.demo.service.VehicalServiceImpl;
import com.vst.demo.util.ExcelReader;

import jakarta.validation.Valid;

@RestController
@RequestMapping("vehical")
public class VehicalController {

	private static final Logger logger = LogManager.getLogger(VehicalController.class);

	@Autowired
	VehicalServiceImpl vService;

	@Autowired
	SequenceGeneratorService sequenceService;

	@Autowired
	KafkaPublisher kafkaPublisher;
	
	@Autowired
	VehicalConverter vehicalConverter;

	// get method for read the excel file for excel reader
	@GetMapping("info")
	public List<Vehical> getExcelData() {
		ExcelReader exr = new ExcelReader();
		return exr.vehicalTestReader();

	}


	// post/save the vehical details
	@PostMapping("vehical")
	public String saveVehicalDetail(@Valid @RequestBody VehicalDTO vehical) {

		// for auto id update
		vehical.setId(sequenceService.getSequenceNumber(VehicalDTO.SEQUENCE_NAME));
		vehical.setActive(true);
		
		VehicalDTO objDto = vService.saveVehicalDetailsService(vehical);
		
		if(objDto!=null) {
			return "Vehical Added Successfully";
		}else {
			logger.error("Something Went Wrong, Please Check The Details You Entered");
		    return " something went wrong please check your details";
		}

	}

	// soft delete, or deregister the vehical
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

	// update the vehical details
	
	@PutMapping("vehical")
	public String UpdateVehical(@RequestParam("id") int id, @Valid @RequestBody VehicalDTO vehical) {

		try {
			vService.updateVehicalService(id, vehical);
			return "Vehical update successfully";
		} catch (VehicalException e) {

			logger.error("Something went wrong please check details");
			throw new VehicalException(e.getMessage());
		}
	}

	// find vehical by id
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

	// get all vehical details
	@GetMapping("vehicals") // read all details
	public List<Vehical> getAllDetails() {

		List list = vService.findVehicalListService();

		if (!list.isEmpty()) {
			return list;
		} else {

			throw new VehicalException("No data found");
		}

	}

	// find vehical by registration no.
	@GetMapping("vehicalRegistrationNo") // read details by registration no
	public Vehical getvehicalByRegistrationNo(@RequestParam("number") String number) {

		Vehical vh = vService.findVehicalByRegistrationNo(number);
		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");

	}

	// find vehical by veical class
	@GetMapping("vehicalClass") // read details by vehical class
	public Vehical getVehicalByVehicalClass(@RequestParam("vclass") String vclass) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalClass(vclass);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by vehical company
	@GetMapping("vehicalCompany") // read details by vehical company
	public Vehical getVehicalByVehicalCompany(@RequestParam("company") String company) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalCompany(company);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by vehical model
	@GetMapping("VehicalModel") // read details by model
	public Vehical getVehicalByVehicalModel(@RequestParam("model") String model) {

		Vehical vh = (Vehical) vService.findVehicalByVehicalModel(model);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by battry type
	@GetMapping("VehicalBattryType") // read details by battry type
	public Vehical getVehicalByVehicalBattryType(@RequestParam("type") String type) {

		Vehical vh = (Vehical) vService.findVehicalByBattryType(type);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by battry capacity
	@GetMapping("VehicalBattryCapacity") // read details by battry capacity
	public Vehical getVehicalByVehicalBattryCapacity(@RequestParam("capacity") String capacity) {

		Vehical vh = (Vehical) vService.findVehicalByBattryCapacity(capacity);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by adaptor type
	@GetMapping("VehicalAdaptorType") // read details by adaptor type
	public Vehical getVehicalByVehicalAdaptorType(@RequestParam("atype") String atype) {

		Vehical vh = (Vehical) vService.findVehicalByAdaptorType(atype);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// find vehical by owner uid
	@GetMapping("VehicalOwnerUID") // read details by owner UID
	public Vehical getVehicalByVehicalOwnerUID(@RequestParam("UID") String UID) {

		Vehical vh = (Vehical) vService.findVehicalByOwnerUID(UID);

		if (vh != null)
			return vh;
		else
			throw new VehicalException("no data found");
	}

	// save multiple details at a time
	@GetMapping("multiple")
	public boolean saveMultiple() {

		for (int i = 1; i < 10000; i++) {
			VehicalDTO vehical = new VehicalDTO();

			vehical.setVehicalRegistrationNo("MH23RF6543" + i);
			vehical.setVehicalClass("SUV" + i);
			vehical.setVehicalCompany("TATA" + i);
			vehical.setVehicalModel("nexon" + i);
			vehical.setVehicalColour("white" + i);
			vehical.setVehicalBattryType("Lithium-ion" + i);
			vehical.setVehicalBattryCapacity("30.2kWh" + i);
			vehical.setVehicalBattryWarranty("5years" + i);
			vehical.setVehicalAdaptorType("CSS2" + i);
			vehical.setVehicalTimeToCharge("9 Hour" + i);
			vehical.setVehicalPowerOutlet("front" + i);
			vehical.setVehicalChargeRange("60km" + i);
			vehical.setVehicalOwnerName("nikita" + i);
			vehical.setVehicalOwnerUID("243578765432" + i);
			vehical.setVehicalOwnerContactDetails("8765432345" + i);
			vehical.setVehicalOwnerAddress("Nagpur" + i);
			saveVehicalDetail(vehical);

		}
		return true;

	}

	@PostMapping("/kafka")
	public VehicalDTO kafkaPublishVehical(@RequestBody VehicalDTO vehical) {
		kafkaPublisher.getVehical(vehical);
		return vehical;
	}

	@GetMapping("/kafka/{message}")
	public String kafkaPublishMassage(@PathVariable String message) {
		kafkaPublisher.getMessage(message);
		return "data published to kafka";
	}
}
