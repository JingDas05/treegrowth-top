package top.treegrowth.es.service;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import top.treegrowth.model.elastic.IndexInfo;
import top.treegrowth.model.elastic.QueryReq;
import top.treegrowth.model.entity.Page;
import top.treegrowth.model.response.PageDetail;
import top.treegrowth.model.response.PageRes;

import java.util.List;

/**
 * @author wusi
 * @version 2017/4/4 8:44.
 */
public interface IElasticService<T> {

    IndexResponse index(T data, IndexInfo indexInfo);

    BulkResponse bulkIndex(List<Page> pages, IndexInfo indexInfo);

    PageRes<PageDetail> search(QueryReq queryReq);
}
