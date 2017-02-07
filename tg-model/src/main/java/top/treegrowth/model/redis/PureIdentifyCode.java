package top.treegrowth.model.redis;

public class PureIdentifyCode {

    private String phoneNum;
    private String code;
    private Long expiry;

    public PureIdentifyCode() {};

    public PureIdentifyCode(String phoneNum, String code, Long expiry) {
        this.phoneNum = phoneNum;
        this.code = code;
        this.expiry = expiry;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }
}
