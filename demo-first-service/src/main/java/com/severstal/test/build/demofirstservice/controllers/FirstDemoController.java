package com.severstal.test.build.demofirstservice.controllers;

import com.severstal.test.build.demofirstservice.domain.TestEntity;
import com.severstal.test.build.demofirstservice.service.KafkaMessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class FirstDemoController {

    KafkaMessageService service;

    JavaMailSender sender;

    // localhost:8881/first/message
    /**
     * Сообщение от первого сервиса
     * @return Сообщение
     */
    @GetMapping("/message")
    public String firstDemo(/*@Pattern(regexp = "a{2,}", message = "Не верный параметр 'message'")*/ @RequestParam("message") String message) {
        service.sendMessage(message);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("aleksiev_vova@mail.ru");
        msg.setTo("vb010894@gmail.com");
        msg.setSubject("Test");
        msg.setText(message);
        this.sender.send(msg);
        return "Message send";
    }

    @PostMapping("/check")
    public String checkEntity(@Valid @RequestBody TestEntity entity) {
        return "Ok";
    }
}
