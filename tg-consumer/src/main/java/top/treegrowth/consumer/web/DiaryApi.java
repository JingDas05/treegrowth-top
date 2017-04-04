package top.treegrowth.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.treegrowth.model.response.DiaryDetail;
import top.treegrowth.model.response.DiaryPure;
import top.treegrowth.provider.service.IDiaryService;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author wusi
 * @version 2017/3/31 6:59.
 */
@RestController
@RequestMapping(value = "/api/service/diaries")
public class DiaryApi {

    @Autowired
    private IDiaryService diaryService;

    @RequestMapping(value = "/create", method = POST)
    public DiaryDetail createDiary(@RequestBody DiaryPure diaryPure) {
        return diaryService.createDiary(diaryPure);
    }
}
