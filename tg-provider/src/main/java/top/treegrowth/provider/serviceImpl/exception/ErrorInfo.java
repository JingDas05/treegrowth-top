package top.treegrowth.provider.serviceImpl.exception;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/2/23 21:54.
 */
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = -1820355950059620919L;
    public static final Integer FORBIDDEN = 403;
    public static final Integer NOT_FOUND = 404;
    public static final Integer ALREADY_EXIST = 409;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
