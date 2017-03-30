package top.treegrowth.provider.service;

import top.treegrowth.provider.serviceImpl.bo.DiaryDetail;
import top.treegrowth.provider.serviceImpl.bo.DiaryPure;

/**
 * @author wusi
 * @version 2017/3/31 7:05.
 */
public interface IDiaryService {

    DiaryDetail createDiary(DiaryPure diaryPure);
}
