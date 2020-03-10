package com.gcalsolaro.kafka.instance;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;

import com.gcalsolaro.kafka.instance.model.Greeting;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		MessageListener listener = context.getBean(MessageListener.class);
		listener.latch.await();
//		context.close();
	}

	@Bean
	public MessageListener messageListener() {
		return new MessageListener();
	}

	public static class MessageListener {
		private CountDownLatch latch = new CountDownLatch(1);

		@KafkaListener(topics = "${topic.name.due}", containerFactory = "kafkaListenerContainerFactory")
		public void greetingListener(Greeting greeting) {
			System.out.println("Recieved greeting message: " + greeting);
			this.latch.countDown();
		}
	}
}
