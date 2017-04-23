package top.treegrowth.model.elastic;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/4 10:24.
 */
public class QueryReq implements Serializable {

    private static final long serialVersionUID = -3921743374052107766L;
    private String keyword;
    private int from;
    private int size;
    private String userId;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
