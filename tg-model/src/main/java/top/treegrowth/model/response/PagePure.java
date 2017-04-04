package top.treegrowth.model.response;

import top.treegrowth.model.entity.Page;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/1 7:21.
 */
public class PagePure implements Serializable {
    private static final long serialVersionUID = -4678443118500127306L;

    private String diaryId;
    private String name;
    private String mind;
    private String content;
    private String weather;
    private String authorId;

    public Page toPage() {
        Page page = new Page();
        page.setName(this.name);
        page.setDiaryId(this.diaryId);
        page.setMind(this.mind);
        page.setContent(this.content);
        page.setWeather(this.weather);
        return page;
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
