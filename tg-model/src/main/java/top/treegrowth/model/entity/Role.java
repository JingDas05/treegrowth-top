package top.treegrowth.model.entity;

/**
 * @author wusi
 * @version 2017/3/30 13:16
 */
public class Role {

    private String id;
    private String authorityId;
    private String code;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
