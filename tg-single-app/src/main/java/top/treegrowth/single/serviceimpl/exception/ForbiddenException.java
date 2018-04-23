package top.treegrowth.single.serviceimpl.exception;

/**
 * @author wusi
 * @version 2017/2/23 21:59.
 */
public class ForbiddenException extends ServiceException {
    private static final long serialVersionUID = 8058696236916180846L;

    public ForbiddenException() {
        super();
    }

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(Throwable cause) {
        super(cause);
    }
}
