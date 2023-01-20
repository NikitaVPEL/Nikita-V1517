package com.vst.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Consumer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@KafkaListener(topics = "kafkaTopic", groupId = "1stPartition")
	public void consumeTopic(String receivemessage) {
		System.out.println("the received massage is " + receivemessage);

	}

}
