package com.vst.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vst.model.User;
import com.vst.service.Producer;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

//	@Autowired(required = true)
//	KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	Producer producer;

	String topic = "mongoindex";

//	@GetMapping("kafka/{name}")
//	public String getKafka(@PathVariable String name) {
//		kafkaTemplate.send(topic, " hii " + name + " welcome to virtuoso");
//		return "data published";
//	}
//
//	@GetMapping("jsonpublisher")
//	public String publishMessage() {
//		User user = new User(1, "nikita", new String[] { "nagpur", "ambedkar square", "house 198" });
//		kafkaTemplate.send(topic, user);
//		return "json data published";
//
//	}

	@PostMapping("jsonpublisher")
	public String publishMessage(@RequestBody User user) {
		producer.userdetails(user);
		return "json data published";

	}
//	
//	@GetMapping("/{message}")
//	public void getMessageFromClient(@PathVariable String message) {
//		producer.produceMessage(message);
//	}
}
