package com.tehranch.paanofrontback.controller;

import com.tehranch.paanofrontback.service.KafkaProducer;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publish(@PathVariable("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }

}
