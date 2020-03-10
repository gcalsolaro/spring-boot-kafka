package com.gcalsolaro.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.gcalsolaro.kafka.producer.model.Greeting;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public MessageProducer messageProducer() {
		return new MessageProducer();
	}

	public static class MessageProducer {

		@Autowired
		private KafkaTemplate<String, Greeting> kafkaTemplate;

		@Value(value = "${topic.name.uno}")
		private String topicName1;

		@Value(value = "${topic.name.due}")
		private String topicName2;

		public void sendMessageToTopic1(Greeting msg) {
			Message<Greeting> message = MessageBuilder.withPayload(msg).setHeader(KafkaHeaders.TOPIC, topicName1)
					.build();

			ListenableFuture<SendResult<String, Greeting>> future = kafkaTemplate.send(message);
			future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {
				@Override
				public void onSuccess(SendResult<String, Greeting> result) {
					System.out.println(
							"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
				}

				@Override
				public void onFailure(Throwable ex) {
					System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
				}
			});
		}

		public void sendMessageToTopic2(Greeting msg, int partition) {

			Message<Greeting> message = MessageBuilder.withPayload(msg).setHeader(KafkaHeaders.TOPIC, topicName2)
					.build();

			ListenableFuture<SendResult<String, Greeting>> future = kafkaTemplate.send(message);
			future.addCallback(new ListenableFutureCallback<SendResult<String, Greeting>>() {
				@Override
				public void onSuccess(SendResult<String, Greeting> result) {
					System.out.println(
							"Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
				}

				@Override
				public void onFailure(Throwable ex) {
					System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
				}
			});
		}
	}
}
