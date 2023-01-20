package com.vst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Autowired(required = true)
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void produceMessage(String message) {
		kafkaTemplate.send("kafkaTopic", message);
	}

}
