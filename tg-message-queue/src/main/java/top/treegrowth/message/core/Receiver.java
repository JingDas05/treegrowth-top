package top.treegrowth.message.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import top.treegrowth.es.service.IElasticService;
import top.treegrowth.model.elastic.IndexInfo;
import top.treegrowth.model.entity.Page;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;
import static top.treegrowth.es.ElasticServiceImpl.INDEX;
import static top.treegrowth.es.ElasticServiceImpl.TYPE;

@Service
public class Receiver {

    @Autowired
    private IElasticService<Page> elasticService;
    public static final String TOPIC = "treegrowth.page";

    @KafkaListener(topics = TOPIC, containerFactory = "jsonKafkaListenerContainerFactory")
    public void receiveUserMessage(Page page) {
        IndexInfo indexInfo = new IndexInfo(INDEX, TYPE, page.getId());
        // 查询的时候用纯文本，所以将content字段(带有html标签)置空，用纯文本字段text
        page.setContent("");
        elasticService.index(page, indexInfo);
    }
}
