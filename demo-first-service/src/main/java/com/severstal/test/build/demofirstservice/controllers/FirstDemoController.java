package com.severstal.test.build.demofirstservice.controllers;

import com.severstal.test.build.demofirstservice.domain.ServiceEntity;
import com.severstal.test.build.demofirstservice.service.KafkaMessageService;
import com.severstal.test.build.demofirstservice.service.RedisService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FirstDemoController {

    KafkaMessageService service;

    RedisService redisService;

    // localhost:8881/first/message
    /**
     * Сообщение от первого сервиса
     * @return Сообщение
     */
    @GetMapping("/message")
    public String firstDemo(@RequestParam("message") String message) {
        service.sendMessage(message);
        return "Message send";
    }

    @PostMapping("/entity")
    public String saveEntity(@RequestBody ServiceEntity entity) {
        redisService.save(entity);
        return "Saved";
    }

    @GetMapping("/entity")
    public ServiceEntity getEntity(@RequestParam("id") String id) {
        Optional<ServiceEntity> entity = redisService.get(id);
        return entity.orElseThrow();
    }
}
