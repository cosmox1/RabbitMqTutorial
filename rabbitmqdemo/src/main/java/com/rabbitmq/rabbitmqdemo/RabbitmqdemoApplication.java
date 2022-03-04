package com.rabbitmq.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//used to send a message!

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public static void main(String[] args) {
        SpringApplication.run(RabbitmqdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //sending simple text message
        //rabbitTemplate.convertAndSend("TestExchange","testRouting","Hello from code!");

        //sending obj
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("First message");
        simpleMessage.setDescription("SimpleDescription");

//        rabbitTemplate.convertAndSend("TestExchange", "testRouting", simpleMessage);
        rabbitTemplate.convertAndSend("MyTopicExchangeTest", "topic", simpleMessage);
    }
}
