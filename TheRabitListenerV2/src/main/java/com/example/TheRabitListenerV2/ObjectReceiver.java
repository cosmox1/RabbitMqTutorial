package com.example.TheRabitListenerV2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

// numele la queu creat in config
@Component
@RabbitListener(queues = "queueToGetObj")
@Slf4j
public class ObjectReceiver {

    @RabbitHandler
    public void recieveObjectFromSender(String objectMessage) {

        ObjectMapper objectMapper = new ObjectMapper(); //cand este primit un string json se foloseste obj mapper pt a face obiect din acesta

        try {
            ObjectMessageReceiverModel messageReceiverModel = objectMapper.readValue(objectMessage, ObjectMessageReceiverModel.class);
            log.info("name recieved is {}", messageReceiverModel.getName());
            log.info("description recieved is {}", messageReceiverModel.getDescription());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }
}
