package top.treegrowth.provider.service;

import top.treegrowth.model.res.DiaryDetail;
import top.treegrowth.model.req.DiaryPure;
import top.treegrowth.model.req.DiaryReq;
import top.treegrowth.model.res.PageRes;

/**
 * @author wusi
 * @version 2017/3/31 7:05.
 */
public interface IDiaryService {

    DiaryDetail createDiary(DiaryPure diaryPure);

    PageRes<DiaryDetail> getDiaries(DiaryReq diaryReq);
}
