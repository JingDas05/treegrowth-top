package top.treegrowth.single.serviceimpl.exception;

/**
 * @author wusi
 * @version 2017/2/23 22:52.
 */
public class AaliApiException extends ServiceException {
    private static final long serialVersionUID = -4673852532058239372L;

    public AaliApiException() {
        super();
    }

    public AaliApiException(String message) {
        super(message);
    }

    public AaliApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AaliApiException(Throwable cause) {
        super(cause);
    }
}
