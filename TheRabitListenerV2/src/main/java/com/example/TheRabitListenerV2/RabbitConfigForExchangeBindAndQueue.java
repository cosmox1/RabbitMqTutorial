package com.example.TheRabitListenerV2;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigForExchangeBindAndQueue {

    //create the queue
    @Bean
    public Queue queToGetObject() {
        return new Queue("queueToGetObj");
    }

    //create the exchange
    @Bean
    public Exchange exchangeToSendObject() {
        return ExchangeBuilder.directExchange("exchangeToSentObj").build();
    }

    //create the binding between exchange and queue
    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queToGetObject())
                .to(exchangeToSendObject())
                .with("key").noargs();
    }

}
