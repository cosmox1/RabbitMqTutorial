package com.example.rabbitlistener.V2;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqQueueConfig {

    //classic queue creation
    @Bean
    public Queue exempleQueue(){
        return new Queue("ExampleQueue",false);
    }

    //another queue creation type
    @Bean
    public Queue exampleSecondQueue(){
        return QueueBuilder.durable("ExampleSecondQueue")
                .autoDelete()
                .exclusive()
                .build();
    }
}
