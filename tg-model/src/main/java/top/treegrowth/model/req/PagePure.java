package top.treegrowth.model.req;

import top.treegrowth.model.entity.Page;
import top.treegrowth.model.req.group.Create;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/4/1 7:21.
 */
public class PagePure implements Serializable {
    private static final long serialVersionUID = -4678443118500127306L;

    @NotNull(groups = {Create.class})
    private String diaryId;
    @Min(1)
    @Max(15)
    private String name;
    private String mind;
    @NotNull(groups = {Create.class})
    private String content;
    private String weather;
    @NotNull(groups = {Create.class})
    private String authorId;
    // 纯文本字段
    private String text;

    public Page toPage() {
        Page page = new Page();
        page.setName(this.name);
        page.setDiaryId(this.diaryId);
        page.setMind(this.mind);
        page.setContent(this.content);
        page.setWeather(this.weather);
        page.setText(this.text);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
