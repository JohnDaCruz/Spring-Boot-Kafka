package com.javakafka.mensageriakafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class MensageriaKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MensageriaKafkaApplication.class, args);
    }

}
@RestController
@RequestMapping("/kafka")
class KafkaControllerEndPoint {
    public KafkaControllerEndPoint(HelloProducer service) {
        this.service = service;
    }

    @Autowired
    private HelloProducer service;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        service.sendMessage(name);
        return "OK";
    }

}



