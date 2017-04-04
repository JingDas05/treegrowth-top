package top.treegrowth.provider.service;

import top.treegrowth.model.response.DiaryDetail;
import top.treegrowth.model.response.DiaryPure;

/**
 * @author wusi
 * @version 2017/3/31 7:05.
 */
public interface IDiaryService {

    DiaryDetail createDiary(DiaryPure diaryPure);
}
