package top.treegrowth.model.req;

import top.treegrowth.model.entity.Diary;
import top.treegrowth.model.req.group.Create;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/3/31 7:01.
 */
public class DiaryPure implements Serializable {

    private static final long serialVersionUID = 8457059822832757385L;
    @NotNull(groups = {Create.class})
    @Min(1)
    @Max(15)
    private String name;
    @NotNull(groups = {Create.class})
    @Min(1)
    @Max(20)
    private String description;
    @NotNull(groups = {Create.class})
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
