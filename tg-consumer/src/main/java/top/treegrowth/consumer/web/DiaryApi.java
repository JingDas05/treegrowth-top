package top.treegrowth.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.consumer.service.DiaryService;
import top.treegrowth.model.req.group.Create;
import top.treegrowth.model.res.DiaryDetail;
import top.treegrowth.model.req.DiaryPure;
import top.treegrowth.model.req.DiaryReq;
import top.treegrowth.model.res.PageRes;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/3/31 6:59.
 */
@RestController
@RequestMapping(value = "/api/diaries")
public class DiaryApi {

    @Autowired
    private DiaryService diaryService;

    @RequestMapping(value = "/create", method = POST)
    public DiaryDetail createDiary(@RequestBody @Validated({Create.class}) DiaryPure diaryPure) {
        return diaryService.createDiary(diaryPure);
    }

    @RequestMapping(method = POST)
    public PageRes<DiaryDetail> getDiaries(@RequestBody DiaryReq diaryReq) {
        return diaryService.getDiaries(diaryReq);
    }
}
