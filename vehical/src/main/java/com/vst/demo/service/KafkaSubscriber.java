package com.vst.demo.service;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.vst.demo.model.Vehical;

@Service
public class KafkaSubscriber {
	
	@KafkaListener(topics = "Vehical",groupId = "1st")
	public void kafkaListner(@Payload List<Vehical> vehical) {
		System.out.println(vehical);
	}
	
	@KafkaListener(topics = "vehicalMessage",groupId = "1st")
	public void kafkamessageListner(String message) {
		System.out.println(message);
	}

}
