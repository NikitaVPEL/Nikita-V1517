package com.vst.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vst.demo.exception.VehicalException;
import com.vst.demo.model.Vehical;
import com.vst.demo.repository.VehicalRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class VehicalServiceImpl implements VehicalServiceInterface {

	@Autowired
	VehicalRepository vRepo;

	@Override
	@Transactional
	public boolean saveVehicalDetailsService(Vehical vehical) {
		// it will call the repository save method to add the details
		vRepo.save(vehical);
		return true;
	}
	

	@Override
	@Transactional
	public boolean deleteVehicalByIdService(int id) {

		Vehical vhs = vRepo.findByIdAndIsActiveTrue(id);

		// set the is active value to false and save
		if (vhs != null) {
			vhs.setActive(false);
			vRepo.save(vhs);
			return true;
		} else {

			throw new VehicalException("vehical is not available in databasse");
		}
	}
	

	@Override
	@Transactional
	public boolean updateVehicalService( int id, Vehical vehical) {

		Vehical obj = vRepo.findByIdAndIsActiveTrue(id);

		if (obj.getId() > 0) {

			
			if (vehical.getVehicalRegistrationNo() != null) {
				obj.setVehicalRegistrationNo(vehical.getVehicalRegistrationNo());
			}
			if (vehical.getVehicalClass() != null) {
				obj.setVehicalClass(vehical.getVehicalClass());
			}
			if (vehical.getVehicalCompany() != null) {
				obj.setVehicalCompany(vehical.getVehicalCompany());
			}
			if (vehical.getVehicalModel() != null) {
				obj.setVehicalModel(vehical.getVehicalModel());
			}
			if (vehical.getVehicalColour() != null) {
				obj.setVehicalColour(vehical.getVehicalColour());
			}
			if (vehical.getVehicalBattryType() != null) {
				obj.setVehicalBattryType(vehical.getVehicalBattryType());
			}
			if (vehical.getVehicalBattryCapacity() != null) {
				obj.setVehicalBattryCapacity(vehical.getVehicalBattryCapacity());
			}
			if (vehical.getVehicalBattryWarranty() != null) {
				obj.setVehicalBattryWarranty(vehical.getVehicalBattryWarranty());
			}
			if (vehical.getVehicalAdaptorType() != null) {
				obj.setVehicalAdaptorType(vehical.getVehicalAdaptorType());
			}
			if (vehical.getVehicalTimeToCharge() != null) {
				obj.setVehicalTimeToCharge(vehical.getVehicalTimeToCharge());
			}
			if (vehical.getVehicalPowerOutlet() != null) {
				obj.setVehicalPowerOutlet(vehical.getVehicalPowerOutlet());
			}
			if (vehical.getVehicalChargeRange() != null) {
				obj.setVehicalChargeRange(vehical.getVehicalChargeRange());
			}
			if (vehical.getVehicalOwnerName() != null) {
				obj.setVehicalOwnerName(vehical.getVehicalOwnerName());
			}
			if (vehical.getVehicalOwnerUID() != null) {
				obj.setVehicalOwnerUID(vehical.getVehicalOwnerUID());
			}
			if (vehical.getVehicalOwnerContactDetails() != null) {
				obj.setVehicalOwnerContactDetails(vehical.getVehicalOwnerContactDetails());
			}
			if (vehical.getVehicalOwnerAddress() != null) {
				obj.setVehicalOwnerAddress(vehical.getVehicalOwnerAddress());
			}
		}
		vRepo.save(obj);
		return true;
	}
	

	@Override
	@Transactional
	public Vehical findVehicalByIdService(int id) {
		return vRepo.findByIdAndIsActiveTrue(id);

	}
	

	@Override
	@Transactional
	public List<Vehical> findVehicalListService() {
           return vRepo.findAllByIsActiveTrue();
	}

	
	@Override
	@Transactional
	public Vehical findVehicalByRegistrationNo(String number) {
		return vRepo.findByVehicalRegistrationNoAndIsActiveTrue(number);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByVehicalClass(String vclass) {
		return vRepo.findByVehicalClassAndIsActiveTrue(vclass);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByVehicalCompany(String company) {
		return vRepo.findByVehicalCompany(company);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByVehicalModel(String model) {
		return vRepo.findByVehicalModel(model);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByBattryType(String type) {
		return vRepo.findByVehicalBattryType(type);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByBattryCapacity(String capacity) {
		return vRepo.findByVehicalBattryCapacity(capacity);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByAdaptorType(String atype) {
		return vRepo.findByVehicalAdaptorType(atype);
	}

	
	@Override
	@Transactional
	public List<Vehical> findVehicalByOwnerUID(String UID) {
		return vRepo.findByVehicalOwnerUID(UID);
	}

	
}
