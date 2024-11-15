package com.severstal.test.build.demosecondservice.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class KafkaMessageListener {

    @KafkaListener(topics = "topic-11", groupId = "group-11")
    public void listen(String message) {
        log.info(message);
    }
}
