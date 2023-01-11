package com.vst.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vst.demo.model.Vehical;

@Repository
public interface VehicalRepository extends MongoRepository<Vehical, Integer> {
	
	public Vehical findByVehicalRegistrationNoAndIsActiveTrue(String number);
	
	public List<Vehical>findByVehicalClassAndIsActiveTrue(String vclass);
	
	public List<Vehical>findByVehicalCompany(String company);
	
	public List<Vehical>findByVehicalModel(String model);
	
	public List<Vehical>findByVehicalBattryType(String type);
	
	public List<Vehical>findByVehicalBattryCapacity(String capacity);
	
	public List<Vehical>findByVehicalAdaptorType(String atype);
	
	public List<Vehical>findByVehicalOwnerUID(String UID);
	
	public Vehical findByIdAndIsActiveTrue(int id);
	
	public List<Vehical> findAllByIsActiveTrue();
	


}
