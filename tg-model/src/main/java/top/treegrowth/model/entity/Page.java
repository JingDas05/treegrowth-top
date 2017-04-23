package top.treegrowth.model.entity;

import java.util.Date;

/**
 * @author wusi
 * @version 2017/3/30 13:00
 */
public class Page {

    private String id;
    private String diaryId;
    private String name;
    private Date createTime;
    private String mind;
    private String content;
    private String weather;

    //elastic 过滤字段
    private String authorId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDiaryId() {
        return diaryId;
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

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }

    public String getContent() {
        return content;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
