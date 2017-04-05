package top.treegrowth.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.treegrowth.model.res.DiaryDetail;
import top.treegrowth.model.req.DiaryPure;
import top.treegrowth.model.req.DiaryReq;
import top.treegrowth.model.res.PageRes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/4/6 6:50.
 */
@FeignClient("provider")
@RequestMapping(value = "/api/service/diaries")
public interface DiaryService {

    @RequestMapping(value = "/create", method = POST)
    DiaryDetail createDiary(@RequestBody DiaryPure diaryPure);

    @RequestMapping(method = POST)
    public PageRes<DiaryDetail> getDiaries(@RequestBody DiaryReq diaryReq);
}
