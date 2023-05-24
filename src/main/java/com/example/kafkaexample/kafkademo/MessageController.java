package com.example.kafkaexample.kafkademo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
    private Kafkaproducer kafkaproducer;

    private JsonKafkaProducer jsonkafkaProducer;

    public MessageController(Kafkaproducer kafkaproducer, JsonKafkaProducer jsonkafkaProducer) {
        this.kafkaproducer = kafkaproducer;
        this.jsonkafkaProducer = jsonkafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaproducer.sendMessage(message);
        return ResponseEntity.ok("message send to topic");
    }

    @PostMapping("/publishjson")
    public ResponseEntity<String> publishjsondata(@RequestBody User user){
        jsonkafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json message send to topic");
    }

}
