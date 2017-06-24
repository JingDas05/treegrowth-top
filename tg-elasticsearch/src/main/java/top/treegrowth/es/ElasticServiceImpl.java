package top.treegrowth.es;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.treegrowth.es.service.IElasticService;
import top.treegrowth.model.elastic.IndexInfo;
import top.treegrowth.model.elastic.QueryReq;
import top.treegrowth.model.entity.Page;
import top.treegrowth.model.res.PageDetail;
import top.treegrowth.model.res.PageRes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.elasticsearch.index.query.QueryBuilders.multiMatchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static top.treegrowth.common.utils.Constants.DATE_FORMAT;

/**
 * @author wusi
 * @version 2017/4/4 8:44.
 */
@Service
public class ElasticServiceImpl<T> implements IElasticService<T> {

    @Autowired
    private TransportClient client;
    private static final String AUTHOR_ID = "authorId";
    private static final String NAME = "name";
    private static final String CONTENT = "content";
    private static final String TEXT = "text";
    public static final String INDEX = "diary";
    public static final String TYPE = "page";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);

    @Override
    public IndexResponse index(T data, IndexInfo indexInfo) {
        return client.prepareIndex(indexInfo.getIndex(), indexInfo.getType(), indexInfo.getId())
                .setSource(JSON.toJSONStringWithDateFormat(data, DATE_FORMAT), XContentType.JSON)
                .get();
    }

    @Override
    public BulkResponse bulkIndex(List<Page> pages, IndexInfo indexInfo) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        String index = indexInfo.getIndex();
        String type = indexInfo.getType();
        pages.forEach(data -> bulkRequest.add(client.prepareIndex(index, type, data.getId())
                .setSource(JSON.toJSONStringWithDateFormat(data, DATE_FORMAT), XContentType.JSON)
        ));
        return bulkRequest.get();
    }

    @Override
    public PageRes<PageDetail> search(QueryReq queryReq) {
        SearchResponse searchResponse;
        PageRes<PageDetail> pageRes = new PageRes<>();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(NAME);
        // 为了兼容之前的数据
        highlightBuilder.field(CONTENT);
        highlightBuilder.field(TEXT);
        highlightBuilder.preTags("<b style='color:#ff0000'>");
        highlightBuilder.postTags("</b>");
        searchResponse = client.prepareSearch(INDEX)
                .setTypes(TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                //为了兼容之前的数据，没有去掉 CONTENT
                .setQuery(multiMatchQuery(queryReq.getKeyword(), NAME, CONTENT, TEXT))
                .setPostFilter(termQuery(AUTHOR_ID, queryReq.getUserId()))
                .setFrom(queryReq.getFrom())
                .setSize(queryReq.getSize())
                .highlighter(highlightBuilder)
                .get();
        SearchHits searchHits = searchResponse.getHits();
        pageRes.setTotal(searchHits.getTotalHits());
        List<SearchHit> hits = Arrays.asList(searchHits.getHits());
        List<PageDetail> pageDetails = hits.stream()
                .map(searchHit -> {
                    HighlightField nameHighlightField = searchHit.getHighlightFields().get("name");
                    HighlightField contentHighlightField = searchHit.getHighlightFields().get("content");
                    HighlightField textHighlightField = searchHit.getHighlightFields().get("text");
                    Map<String, Object> source = searchHit.getSource();
                    PageDetail pageDetail = new PageDetail();
                    pageDetail.setId(searchHit.getId());
                    pageDetail.setName(nameHighlightField == null ?
                            String.valueOf(source.get("name"))
                            : nameHighlightField.getFragments()[0].toString());
                    pageDetail.setCreateTime(dateTimeFormatter.parseDateTime(String.valueOf(source.get("createTime"))).toDate());
                    // 为了兼容老数据， 先取text， 再取content，如果都为空就用content字段的值
                    pageDetail.setContent(textHighlightField != null? textHighlightField.getFragments()[0].toString() :
                            (contentHighlightField == null ? String.valueOf(source.get("content")) : contentHighlightField.getFragments()[0].toString()));
                    pageDetail.setMind(String.valueOf(source.get("mind")));
                    pageDetail.setWeather(String.valueOf(source.get("weather")));
                    pageDetail.setDiaryId(String.valueOf(source.get("diaryId")));
                    return pageDetail;
                })
                .collect(Collectors.toList());
        pageRes.setData(pageDetails);
        pageRes.setLast(queryReq.getFrom() + queryReq.getSize() >= searchHits.getTotalHits());
        return pageRes;
    }
}
