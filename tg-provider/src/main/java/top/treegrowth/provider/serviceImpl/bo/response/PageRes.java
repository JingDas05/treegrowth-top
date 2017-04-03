package top.treegrowth.provider.serviceImpl.bo.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author wusi
 * @version 2017/4/2 22:56.
 */
public class PageRes<T> implements Serializable {
    private static final long serialVersionUID = 4008274847648869238L;

    private List<T> data;
    private int total;
    private boolean isLast;

    public PageRes() {
    }

    public PageRes(List<T> data, int total, boolean isLast) {
        this.data = data;
        this.total = total;
        this.isLast = isLast;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
