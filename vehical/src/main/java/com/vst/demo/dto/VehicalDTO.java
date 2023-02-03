package com.vst.demo.dto;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicalDTO {
	
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
	

}
