package top.treegrowth.provider.serviceImpl.bo;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/2 22:56.
 */
public class PagesResponse<T> implements Serializable {
    private static final long serialVersionUID = 4008274847648869238L;

    private T data;
    private int total;
    private boolean isLast;

    public PagesResponse() {
    }

    public PagesResponse(T data, int total, boolean isLast) {
        this.data = data;
        this.total = total;
        this.isLast = isLast;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
