package com.example.drools_practise.consumer;

import com.example.drools_practise.dto.IncomingSMS;
import com.example.drools_practise.service.root.CommandPreProcessing;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final CommandPreProcessing commandPreProcessing;

    private ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(IncomingSMS incomingSMS) {

        log.info("MessageBody from JSON message :{}", incomingSMS.toString());

        commandPreProcessing.preProcessing(incomingSMS);
    }
}