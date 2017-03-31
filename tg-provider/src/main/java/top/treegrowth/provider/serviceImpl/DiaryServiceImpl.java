package top.treegrowth.provider.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.treegrowth.model.entity.Diary;
import top.treegrowth.provider.dao.mapper.DiaryMapper;
import top.treegrowth.provider.service.IDiaryService;
import top.treegrowth.provider.serviceImpl.bo.DiaryDetail;
import top.treegrowth.provider.serviceImpl.bo.DiaryPure;

import java.util.Date;

import static top.treegrowth.common.utils.Generator.uuid;

/**
 * @author wusi
 * @version 2017/3/31 7:09.
 */
@Service
public class DiaryServiceImpl implements IDiaryService {

    @Autowired
    private DiaryMapper diaryMapper;

    /**
     * @param userId 当前登录用户id
     * @param diary  当前新创建的日记
     */
    public DiaryDetail getDetail(Diary diary, String userId) {
        DiaryDetail diaryDetail = new DiaryDetail();
        diaryDetail.setId(diary.getId());
        diaryDetail.setName(diary.getName());
        diaryDetail.setCreateUserId(diary.getCreateUserId());
        diaryDetail.setCreateTime(diary.getCreateTime());
        diaryDetail.setDescription(diary.getDescription());
        return fillInWithUserState(diaryDetail, userId);
    }

    @Transactional
    @Override
    public DiaryDetail createDiary(DiaryPure diaryPure) {
        Diary diary = diaryPure.toDiary();
        diary.setId(uuid());
        diary.setCreateTime(new Date());
        diaryMapper.createDiary(diary);
        return getDetail(diary, diaryPure.getCreateUserId());
    }

    private DiaryDetail fillInWithUserState(DiaryDetail diaryDetail, String userId) {
        return diaryDetail;
    }
}
