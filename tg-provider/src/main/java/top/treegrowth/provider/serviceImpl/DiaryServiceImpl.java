package top.treegrowth.provider.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.treegrowth.model.entity.Diary;
import top.treegrowth.model.res.DiaryDetail;
import top.treegrowth.model.req.DiaryPure;
import top.treegrowth.model.req.DiaryReq;
import top.treegrowth.model.res.PageRes;
import top.treegrowth.provider.dao.mapper.DiaryMapper;
import top.treegrowth.provider.service.IDiaryService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        diaryDetail.setCreateUserId(diary.getAuthorId());
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
        return getDetail(diary, diaryPure.getAuthorId());
    }

    @Override
    public PageRes<DiaryDetail> getDiaries(DiaryReq diaryReq) {
        int pageNum = diaryReq.getPageNum();
        int pageSize = diaryReq.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Diary> diaries = diaryMapper.getDiaries(diaryReq.getUserId());
        PageInfo<Diary> pageInfo = new PageInfo<>(diaries);
        List<DiaryDetail> diaryDetails = pageInfo.getList().stream()
                .map(diary -> getDetail(diary, diaryReq.getUserId()))
                .collect(Collectors.toList());

        return new PageRes<>(diaryDetails, pageInfo.getTotal(), (pageNum + 1) * pageSize >= pageInfo.getTotal());
    }

    private DiaryDetail fillInWithUserState(DiaryDetail diaryDetail, String userId) {
        return diaryDetail;
    }
}
