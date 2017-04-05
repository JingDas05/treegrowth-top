package top.treegrowth.model.res;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wusi
 * @version 2017/3/31 7:03.
 */
public class DiaryDetail implements Serializable{

    private static final long serialVersionUID = 6393521194095434227L;
    private String id;
    private String name;
    private Date createTime;
    private String description;
    private String createUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }
}
