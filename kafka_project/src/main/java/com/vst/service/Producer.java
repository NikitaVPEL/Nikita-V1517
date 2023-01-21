package com.vst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.vst.model.User;

@Service
public class Producer {
	
	@Autowired(required = true)
	KafkaTemplate<String, Object> kafkaTemplate;
	
//	public void produceMessage(String message) {
//		kafkaTemplate.send("kafkaTopic", message);
//	}
	
	public void userdetails(User user) {
		
		kafkaTemplate.send("mongoindex", user);
		System.out.println(user);
	}
}
