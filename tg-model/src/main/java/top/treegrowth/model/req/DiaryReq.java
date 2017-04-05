package top.treegrowth.model.req;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/6 6:55.
 */
public class DiaryReq implements Serializable {

    private static final long serialVersionUID = 4534155009205757647L;
    private String userId;
    private int pageNum;
    private int pageSize;

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
}
