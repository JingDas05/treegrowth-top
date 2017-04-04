package top.treegrowth.message.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import top.treegrowth.es.service.IElasticService;
import top.treegrowth.model.elastic.IndexInfo;
import top.treegrowth.model.entity.Page;

@Service
public class Receiver {

    @Autowired
    private IElasticService<Page> elasticService;

    @KafkaListener(topics = "treegrowth.page", containerFactory = "jsonKafkaListenerContainerFactory")
    public void receiveUserMessage(Page page) {
        IndexInfo indexInfo = new IndexInfo("diary", "page", page.getId());
        elasticService.index(page, indexInfo);
    }
}
