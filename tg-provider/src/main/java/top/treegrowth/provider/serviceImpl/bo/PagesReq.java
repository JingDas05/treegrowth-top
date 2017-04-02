package top.treegrowth.provider.serviceImpl.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusi
 * @version 2017/4/2 22:52.
 */
public class PagesReq implements Serializable {

    private static final long serialVersionUID = -5518814713181344386L;
    private String userId;
    private int pageNum;
    private int pageSize;
    private String diaryId;
    private Date beginTime;
    private Date endTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
