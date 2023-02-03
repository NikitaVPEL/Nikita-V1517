package com.vst.demo.Converter;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.vst.demo.dto.VehicalDTO;
import com.vst.demo.model.Vehical;

@Component
public class VehicalConverter {
	
	public Vehical dtoToEntity(VehicalDTO vehical) {
		
		Vehical object = new Vehical();
		BeanUtils.copyProperties(vehical, object);
		return object;
	}
	
	public VehicalDTO entityToDto(Vehical vehical) {
		VehicalDTO object = new VehicalDTO();
		BeanUtils.copyProperties(vehical, object);
		return object;
	}

}
