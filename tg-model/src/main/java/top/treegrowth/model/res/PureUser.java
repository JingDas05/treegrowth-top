package top.treegrowth.model.res;

import javax.validation.constraints.NotNull;

public class PureUser {

    @NotNull
    private String phone;
    @NotNull
    private String password;
    @NotNull
    private String code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
