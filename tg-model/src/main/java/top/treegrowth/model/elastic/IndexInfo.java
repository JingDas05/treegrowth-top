package top.treegrowth.model.elastic;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/4 8:47.
 */
public class IndexInfo implements Serializable {

    private static final long serialVersionUID = 8285747735575902580L;
    private String index;
    private String type;
    private String id;

    public IndexInfo() {
    }

    public IndexInfo(String index, String type, String id) {
        this.index = index;
        this.type = type;
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
