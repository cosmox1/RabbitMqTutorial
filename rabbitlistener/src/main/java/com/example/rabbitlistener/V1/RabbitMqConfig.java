package com.example.rabbitlistener.V1;

import com.example.rabbitlistener.RabbitMqMessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class RabbitMqConfig {
//
//    private static final String MY_QUEUE = "MyQueue";
//
//    //create queue
//    @Bean
//    public Queue myQueue() {
//        return new Queue(MY_QUEUE, true);
//    }
//
//    //create a connection
//    @Bean
//    ConnectionFactory connectionFactory() {
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
//        cachingConnectionFactory.setUsername("guest");
//        cachingConnectionFactory.setPassword("guest");
//        return cachingConnectionFactory;
//    }
//
//    @Bean
//    MessageListenerContainer messageListenerContainer() {
//        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
//        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
//        simpleMessageListenerContainer.setQueues(myQueue());
//        simpleMessageListenerContainer.setMessageListener(new RabbitMqMessageListener());
//        return simpleMessageListenerContainer;
//    }
//}
