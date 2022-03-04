package com.example.rabbitlistener;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//message sending
@Configuration
public class RabbitMqExchangeConfiguration {


    //v1
    @Bean
    Exchange exampleExchange() {
        return new TopicExchange("exampleExchange");
    }

    //v2
    @Bean
    Exchange exampleSecondExchange() {
        return ExchangeBuilder.directExchange("exampleScondExchange")
                .autoDelete()
                .internal()
                .build();
    }

    //topic
    @Bean
    Exchange newExchange() {
        return ExchangeBuilder.topicExchange("TopicTestExchange")
                .durable(true)
                .autoDelete()
                .internal()
                .build();
    }

    //fanout
    @Bean
    Exchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("FanoutTestExchange")
                .autoDelete()
                .durable(false)
                .internal()
                .build();
    }

    //headers
    @Bean
    Exchange headersExchange() {
        return ExchangeBuilder.headersExchange("HeadersTestExchange")
                .autoDelete()
                .durable(true)
                .ignoreDeclarationExceptions()
                .build();
    }
}
