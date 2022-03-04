package com.example.rabbitlistener.V3CreatingQueueAndExchangeAndBindThem;

import com.example.rabbitlistener.RabbitMqMessageListener;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//differences between
@Configuration
public class RabbitMqConfigV3 {


    private static final String MY_QUEUE = "MyQueue";

    //create queue
    @Bean
    public Queue myQueue() {
        return new Queue(MY_QUEUE, true);
    }

    //create a Exchange
    @Bean
    Exchange myExchange() {
        return ExchangeBuilder.topicExchange("MyTopicExchangeTest")
                .durable(true)
                .build();
    }

    //binding exchange and queue together
//    @Bean
//    Binding binding(){
//        return new Binding(MY_QUEUE,Binding.DestinationType.QUEUE, "MyTopicExchangeTest","topic",null);
//    }

    //binding exchange and queue with builder
    @Bean
    Binding binding(){
        return BindingBuilder.bind(myQueue())
                .to(myExchange())
                .with("topic")
                .noargs();
    }

    //create a connection
    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }

    @Bean
    MessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
        simpleMessageListenerContainer.setQueues(myQueue());
        simpleMessageListenerContainer.setMessageListener(new RabbitMqMessageListener());
        return simpleMessageListenerContainer;
    }
}

