package com.vst.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Data

@Document (collection = "vehical")
public class Vehical {
	
	@Transient
	public static final String  SEQUENCE_NAME = "charger";

 	@Id
	private int id;
	
 	@NotNull
 	@Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$", message="Enter Valid Registration Number eg.xx00xx0000 ")
	private String vehicalRegistrationNo;
 	
	private String vehicalClass;
	private String vehicalCompany;
	private String vehicalModel;
	private String vehicalColour;
	private String vehicalBattryType;
	private String vehicalBattryCapacity;
	private String vehicalBattryWarranty;
	private String vehicalAdaptorType;
	private String vehicalTimeToCharge;
	private String vehicalPowerOutlet;
	private String vehicalChargeRange;
	
	@NotNull
	private String vehicalOwnerName;
	
	@NotNull
	@Positive
	@Pattern(regexp = "^[0-9]{12}$",message="please insert valid UID")
	private String vehicalOwnerUID;
	
	@NotNull
	@Positive
	@Pattern(regexp = "^[6-9]{1}[0-9]{9}$",message="please insert valid phone number")
	private String vehicalOwnerContactDetails;
	
	private String vehicalOwnerAddress;
	private boolean isActive = true;
	
	public Vehical() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehical(int id,
			@NotNull @Pattern(regexp = "^[A-Z]{2}[0-9]{2}[A-Z]{1,2}[0-9]{4}$", message = "Enter Valid Registration Number eg.xx00xx0000 ") String vehicalRegistrationNo,
			String vehicalClass, String vehicalCompany, String vehicalModel, String vehicalColour,
			String vehicalBattryType, String vehicalBattryCapacity, String vehicalBattryWarranty,
			String vehicalAdaptorType, String vehicalTimeToCharge, String vehicalPowerOutlet, String vehicalChargeRange,
			@NotNull String vehicalOwnerName,
			@NotNull @Positive @Pattern(regexp = "^[0-9]{12}$", message = "please insert valid UID") String vehicalOwnerUID,
			@NotNull @Positive @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "please insert valid phone number") String vehicalOwnerContactDetails,
			String vehicalOwnerAddress, boolean isActive) {
		
		this.id = id;
		this.vehicalRegistrationNo = vehicalRegistrationNo;
		this.vehicalClass = vehicalClass;
		this.vehicalCompany = vehicalCompany;
		this.vehicalModel = vehicalModel;
		this.vehicalColour = vehicalColour;
		this.vehicalBattryType = vehicalBattryType;
		this.vehicalBattryCapacity = vehicalBattryCapacity;
		this.vehicalBattryWarranty = vehicalBattryWarranty;
		this.vehicalAdaptorType = vehicalAdaptorType;
		this.vehicalTimeToCharge = vehicalTimeToCharge;
		this.vehicalPowerOutlet = vehicalPowerOutlet;
		this.vehicalChargeRange = vehicalChargeRange;
		this.vehicalOwnerName = vehicalOwnerName;
		this.vehicalOwnerUID = vehicalOwnerUID;
		this.vehicalOwnerContactDetails = vehicalOwnerContactDetails;
		this.vehicalOwnerAddress = vehicalOwnerAddress;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Vehical [id=" + id + ", vehicalRegistrationNo=" + vehicalRegistrationNo + ", vehicalClass="
				+ vehicalClass + ", vehicalCompany=" + vehicalCompany + ", vehicalModel=" + vehicalModel
				+ ", vehicalColour=" + vehicalColour + ", vehicalBattryType=" + vehicalBattryType
				+ ", vehicalBattryCapacity=" + vehicalBattryCapacity + ", vehicalBattryWarranty="
				+ vehicalBattryWarranty + ", vehicalAdaptorType=" + vehicalAdaptorType + ", vehicalTimeToCharge="
				+ vehicalTimeToCharge + ", vehicalPowerOutlet=" + vehicalPowerOutlet + ", vehicalChargeRange="
				+ vehicalChargeRange + ", vehicalOwnerName=" + vehicalOwnerName + ", vehicalOwnerUID=" + vehicalOwnerUID
				+ ", vehicalOwnerContactDetails=" + vehicalOwnerContactDetails + ", vehicalOwnerAddress="
				+ vehicalOwnerAddress + ", isActive=" + isActive + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicalRegistrationNo() {
		return vehicalRegistrationNo;
	}

	public void setVehicalRegistrationNo(String vehicalRegistrationNo) {
		this.vehicalRegistrationNo = vehicalRegistrationNo;
	}

	public String getVehicalClass() {
		return vehicalClass;
	}

	public void setVehicalClass(String vehicalClass) {
		this.vehicalClass = vehicalClass;
	}

	public String getVehicalCompany() {
		return vehicalCompany;
	}

	public void setVehicalCompany(String vehicalCompany) {
		this.vehicalCompany = vehicalCompany;
	}

	public String getVehicalModel() {
		return vehicalModel;
	}

	public void setVehicalModel(String vehicalModel) {
		this.vehicalModel = vehicalModel;
	}

	public String getVehicalColour() {
		return vehicalColour;
	}

	public void setVehicalColour(String vehicalColour) {
		this.vehicalColour = vehicalColour;
	}

	public String getVehicalBattryType() {
		return vehicalBattryType;
	}

	public void setVehicalBattryType(String vehicalBattryType) {
		this.vehicalBattryType = vehicalBattryType;
	}

	public String getVehicalBattryCapacity() {
		return vehicalBattryCapacity;
	}

	public void setVehicalBattryCapacity(String vehicalBattryCapacity) {
		this.vehicalBattryCapacity = vehicalBattryCapacity;
	}

	public String getVehicalBattryWarranty() {
		return vehicalBattryWarranty;
	}

	public void setVehicalBattryWarranty(String vehicalBattryWarranty) {
		this.vehicalBattryWarranty = vehicalBattryWarranty;
	}

	public String getVehicalAdaptorType() {
		return vehicalAdaptorType;
	}

	public void setVehicalAdaptorType(String vehicalAdaptorType) {
		this.vehicalAdaptorType = vehicalAdaptorType;
	}

	public String getVehicalTimeToCharge() {
		return vehicalTimeToCharge;
	}

	public void setVehicalTimeToCharge(String vehicalTimeToCharge) {
		this.vehicalTimeToCharge = vehicalTimeToCharge;
	}

	public String getVehicalPowerOutlet() {
		return vehicalPowerOutlet;
	}

	public void setVehicalPowerOutlet(String vehicalPowerOutlet) {
		this.vehicalPowerOutlet = vehicalPowerOutlet;
	}

	public String getVehicalChargeRange() {
		return vehicalChargeRange;
	}

	public void setVehicalChargeRange(String vehicalChargeRange) {
		this.vehicalChargeRange = vehicalChargeRange;
	}

	public String getVehicalOwnerName() {
		return vehicalOwnerName;
	}

	public void setVehicalOwnerName(String vehicalOwnerName) {
		this.vehicalOwnerName = vehicalOwnerName;
	}

	public String getVehicalOwnerUID() {
		return vehicalOwnerUID;
	}

	public void setVehicalOwnerUID(String vehicalOwnerUID) {
		this.vehicalOwnerUID = vehicalOwnerUID;
	}

	public String getVehicalOwnerContactDetails() {
		return vehicalOwnerContactDetails;
	}

	public void setVehicalOwnerContactDetails(String vehicalOwnerContactDetails) {
		this.vehicalOwnerContactDetails = vehicalOwnerContactDetails;
	}

	public String getVehicalOwnerAddress() {
		return vehicalOwnerAddress;
	}

	public void setVehicalOwnerAddress(String vehicalOwnerAddress) {
		this.vehicalOwnerAddress = vehicalOwnerAddress;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

	
}
