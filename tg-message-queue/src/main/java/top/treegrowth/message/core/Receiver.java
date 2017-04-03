package top.treegrowth.message.core;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import top.treegrowth.model.entity.Page;

@Service
public class Receiver {

    @KafkaListener(topics = "treegrowth.page", containerFactory = "jsonKafkaListenerContainerFactory")
    public void receiveUserMessage(Page page) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" + page.getId());

    }
}
