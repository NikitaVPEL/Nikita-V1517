package com.vst.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.vst.demo.model.Vehical;

@Service
public class KafkaPublisher {
	
	@Autowired(required = true)
	KafkaTemplate<String, Object> kafkaTemplate;

	public void getVehical(Vehical vehical) {
		kafkaTemplate.send("Vehical", vehical);
	}
	
	public void getMessage(String message) {
		kafkaTemplate.send("vehicalMessage", message);
	}
}
