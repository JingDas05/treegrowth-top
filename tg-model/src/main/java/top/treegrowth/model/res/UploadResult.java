package top.treegrowth.model.res;

import java.io.Serializable;

/**
 * @author wusi
 * @version 2017/6/25 20:15.
 */
public class UploadResult implements Serializable {

    private static final long serialVersionUID = -2250280204917257342L;

    public UploadResult() {
    }

    public UploadResult(String httpPath) {
        this.httpPath = httpPath;
    }

    private String httpPath;

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }
}
