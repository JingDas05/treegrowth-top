package top.treegrowth.provider.serviceImpl.batch.step;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;
import top.treegrowth.provider.serviceImpl.batch.model.Out;

import java.util.List;

/**
 * @author wusi
 * @version 2017/3/18 16:17
 */
@Component
public class ItemWriterCus implements ItemWriter<Out> {

    //这个地方传入的是process的输出，writer都实现了ItemWriter接口，还有其他实现
    @Override
    public void write(List<? extends Out> list) throws Exception {
        //自定义处理
    }
}
