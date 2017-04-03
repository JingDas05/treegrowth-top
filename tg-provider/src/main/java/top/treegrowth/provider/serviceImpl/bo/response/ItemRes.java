package top.treegrowth.provider.serviceImpl.bo.response;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/3 10:48.
 */
public class ItemRes<T> implements Serializable {
    private static final long serialVersionUID = -6243428327525641846L;

    private T data;

    public ItemRes() {
    }

    public ItemRes(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
