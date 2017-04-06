package top.treegrowth.provider.serviceImpl.exception;

/**
 * @author wusi
 * @version 2017/4/7 6:52.
 */
public class IdentifyCodeAlreadyExistException extends ServiceException {
    private static final long serialVersionUID = -6589951863022894981L;

    public IdentifyCodeAlreadyExistException() {
        super();
    }

    public IdentifyCodeAlreadyExistException(String message) {
        super(message);
    }

    public IdentifyCodeAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdentifyCodeAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
