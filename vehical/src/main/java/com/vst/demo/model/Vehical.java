package com.vst.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Getter
@Setter
@Document (collection = "vehical")
public class Vehical {
	

 	@Id
	private int id;
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
	private String vehicalOwnerName;
	private String vehicalOwnerUID;
	private String vehicalOwnerContactDetails;
	private String vehicalOwnerAddress;
	private boolean isActive = true;
	

	
}
