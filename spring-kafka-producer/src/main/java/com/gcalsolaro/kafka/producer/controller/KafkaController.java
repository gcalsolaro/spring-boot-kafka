package com.gcalsolaro.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcalsolaro.kafka.producer.Application.MessageProducer;
import com.gcalsolaro.kafka.producer.model.Greeting;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

	@Autowired
	private MessageProducer producer;

	@GetMapping(value = "/publish/{message}")
	public void sendMessageToKafkaTopic(@PathVariable("message") String name) {
		Greeting greating1 = new Greeting("Messaggio arrivato a destinazione 1", name);
		Greeting greating2 = new Greeting("Messaggio arrivato a destinazione 2", name);

		this.producer.sendMessageToTopic1(greating1);

		this.producer.sendMessageToTopic2(greating2, 0);
	}
}
