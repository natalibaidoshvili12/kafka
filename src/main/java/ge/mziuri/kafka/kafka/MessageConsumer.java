package ge.mziuri.kafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(
            topics = "demo-topic",
            groupId = "demo-group"
    )
    public void consume(String message) {
        System.out.println(
                "Received from Kafka: " + message
        );
    }
}