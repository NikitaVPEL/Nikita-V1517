package com.vst.demo.service;

import java.util.List;

import com.vst.demo.dto.VehicalDTO;
import com.vst.demo.model.Vehical;

public interface VehicalServiceInterface {
	
	public VehicalDTO saveVehicalDetailsService(VehicalDTO vehical);
	
	public boolean deleteVehicalByIdService(int id);
	
	public boolean updateVehicalService(int id, VehicalDTO vehical);

	public Vehical findVehicalByIdService(int id);
	
	public List<Vehical> findVehicalListService();
	
	public Vehical findVehicalByRegistrationNo(String number);
	
	public List<Vehical> findVehicalByVehicalClass(String vclass);
	
	public List<Vehical> findVehicalByVehicalCompany(String company);
	
	public List<Vehical> findVehicalByVehicalModel(String model);
	
	public List<Vehical> findVehicalByBattryType(String type);
	
	public List<Vehical> findVehicalByBattryCapacity(String capacity);
	
	public List<Vehical> findVehicalByAdaptorType(String atype);
	
	public List<Vehical> findVehicalByOwnerUID(String UID);
	
	
}
