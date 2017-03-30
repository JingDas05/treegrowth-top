package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.treegrowth.model.entity.Dream;
import top.treegrowth.provider.dao.mapper.DreamMapper;
import top.treegrowth.provider.service.IDreamService;

import static top.treegrowth.common.utils.Generator.uuid;

/**
 * @author wusi
 * @version 2017/3/18 19:56.
 */
@Service
public class DreamServiceImpl implements IDreamService {

    @Autowired
    private DreamMapper dreamMapper;

    @Override
    public void add(Dream dream) {
        dream.setId(uuid());
        dreamMapper.addDream(dream);
    }

    @Override
    public Dream getBy(String id) {
        return dreamMapper.getDreamBy(id);
    }
}
