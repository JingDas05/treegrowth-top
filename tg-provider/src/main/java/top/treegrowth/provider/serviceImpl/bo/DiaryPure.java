package top.treegrowth.provider.serviceImpl.bo;

import top.treegrowth.model.entity.Diary;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/3/31 7:01.
 */
public class DiaryPure implements Serializable {

    private static final long serialVersionUID = 8457059822832757385L;
    private String name;
    private String description;
    private String authorId;

    public Diary toDiary() {
        Diary diary = new Diary();
        diary.setName(this.getName());
        diary.setDescription(this.getDescription());
        diary.setAuthorId(this.getAuthorId());
        return diary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
