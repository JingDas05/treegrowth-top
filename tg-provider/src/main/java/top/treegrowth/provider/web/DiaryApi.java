package top.treegrowth.provider.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.provider.service.IDiaryService;
import top.treegrowth.provider.serviceImpl.bo.DiaryDetail;
import top.treegrowth.provider.serviceImpl.bo.DiaryPure;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @author wusi
 * @version 2017/3/31 6:59.
 */
@RestController
@RequestMapping(value = "/api/service/diaries")
public class DiaryApi {

    @Autowired
    private IDiaryService diaryService;

    @RequestMapping(method = POST)
    public DiaryDetail createDiary(@RequestBody DiaryPure diaryPure) {
        return diaryService.createDiary(diaryPure);
    }
}
