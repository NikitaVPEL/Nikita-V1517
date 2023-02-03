package com.vst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.vst.demo.Converter.VehicalConverter;
import com.vst.demo.dto.VehicalDTO;
import com.vst.demo.model.Vehical;

@Service
public class KafkaPublisher {
	
	@Autowired(required = true)
	KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	VehicalConverter vehicalConverter;

	public void getVehical(VehicalDTO vehical) {
		
	Vehical objVehical = vehicalConverter.dtoToEntity(vehical);
		kafkaTemplate.send("Vehical", objVehical);
	}
	
	public void getMessage(String message) {
		kafkaTemplate.send("vehicalMessage", message);
	}
}
