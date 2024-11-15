package com.severstal.test.build.demosecondservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondDemoController {

    // localhost:8882/second/message
    /**
     * Сообщение от второго сервиса
     * @return Сообщение
     */
    @GetMapping("/message")
    public String getSecondMessage() {
        return "Hello World! This is the second message";
    }
}
