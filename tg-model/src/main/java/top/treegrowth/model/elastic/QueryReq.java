package top.treegrowth.model.elastic;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/4 10:24.
 */
public class QueryReq implements Serializable {

    private static final long serialVersionUID = -3921743374052107766L;
    private String keyWord;
    private int from;
    private int size;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
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
}
