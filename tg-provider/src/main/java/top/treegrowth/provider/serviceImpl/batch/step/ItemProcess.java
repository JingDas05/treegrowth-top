package top.treegrowth.provider.serviceImpl.batch.step;


import org.springframework.batch.item.ItemProcessor;
import top.treegrowth.provider.serviceImpl.batch.model.In;
import top.treegrowth.provider.serviceImpl.batch.model.Out;

/**
 * @author wusi
 * @version 2017/3/18 16:08
 */
public class ItemProcess implements ItemProcessor<In, Out> {
    @Override
    public Out process(In in) throws Exception {
        //这个地方处理数据的过程，输入是In,输出是Out
        return null;
    }
}
