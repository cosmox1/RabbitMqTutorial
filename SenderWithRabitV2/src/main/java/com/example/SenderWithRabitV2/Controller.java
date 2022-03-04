package com.example.SenderWithRabitV2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sender")
public class Controller {

    private final RabbitTemplate rabbitTemplate;

    public Controller(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/hello")
    public String HelloWorldController() {

        EntityToSend entity = new EntityToSend();
        entity.setName("Test");
        entity.setDescription("TEst DESC");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            //exchangeName e luat din configul din aceasta clasa
            //exchange e luat din configul din listener
            String stringMessageConverted = objectMapper.writeValueAsString(entity);
            rabbitTemplate.convertAndSend("exchangeToSentObj","key",stringMessageConverted);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "hello world";
    }
}
