package top.treegrowth.provider.service;

import top.treegrowth.model.entity.Dream;

/**
 * @author wusi
 * @version 2017/3/18 19:55.
 */
public interface IDreamService {

    void add(Dream dream);

    Dream getBy(String id);
}
