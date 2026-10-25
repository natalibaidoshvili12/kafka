package ge.mziuri.kafka.controller;

import ge.mziuri.kafka.kafka.MessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(
            @RequestBody String message) {

        messageProducer.sendMessage(message);

        return ResponseEntity.accepted()
                .body("Message submitted to Kafka");
    }
}
