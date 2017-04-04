package top.treegrowth.es;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.treegrowth.es.service.IElasticService;
import top.treegrowth.model.elastic.IndexInfo;
import top.treegrowth.model.elastic.QueryReq;
import top.treegrowth.model.entity.Page;
import top.treegrowth.model.response.PageDetail;
import top.treegrowth.model.response.PageRes;

import java.util.Arrays;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;

/**
 * @author wusi
 * @version 2017/4/4 8:44.
 */
@Service
public class ElasticServiceImpl<T> implements IElasticService<T> {

    @Autowired
    private TransportClient client;
    private static final String NAME = "name";
    private static final String CONTENT = "content";
    private static final String INDEX = "diary";
    private static final String TYPE = "page";

    @Override
    public IndexResponse index(T data, IndexInfo indexInfo) {
        return client.prepareIndex(indexInfo.getIndex(), indexInfo.getType(), indexInfo.getId())
                .setSource(JSON.toJSONString(data))
                .get();
    }

    @Override
    public BulkResponse bulkIndex(List<Page> pages, IndexInfo indexInfo) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        String index = indexInfo.getIndex();
        String type = indexInfo.getType();
        pages.forEach(data -> bulkRequest.add(client.prepareIndex(index, type, data.getId())
                .setSource(JSON.toJSONString(data))
        ));
        return bulkRequest.get();
    }

    @Override
    public PageRes<PageDetail> search(QueryReq queryReq) {
        SearchResponse searchResponse;
        PageRes<PageDetail> pageRes = new PageRes<>();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(NAME);
        highlightBuilder.field(CONTENT);
        searchResponse = client.prepareSearch(INDEX)
                .setTypes(TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(multiMatchQuery(queryReq.getKeyWord(), NAME, CONTENT))
                .setFrom(queryReq.getFrom())
                .setSize(queryReq.getSize())
                .highlighter(highlightBuilder)
                .get();
        SearchHits searchHits = searchResponse.getHits();
        long total = searchHits.getTotalHits();
        List<SearchHit> hits = Arrays.asList(searchHits.getHits());

        return pageRes;
    }
}
