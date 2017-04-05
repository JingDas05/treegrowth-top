package top.treegrowth.model.res;

import top.treegrowth.model.entity.User;

import java.io.Serializable;

public class ReturnUser implements Serializable {

    private static final long serialVersionUID = 9213006528878666959L;
    private String id;
    private String phone;

    public ReturnUser() {
    }

    public ReturnUser(User user) {
        this.id = user.getId();
        this.phone = user.getPhone();
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }
}
