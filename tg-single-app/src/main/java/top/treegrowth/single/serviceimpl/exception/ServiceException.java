package top.treegrowth.single.serviceimpl.exception;

/**
 * @author wusi
 * @version 2017/2/23 21:51.
 */
public abstract class ServiceException extends RuntimeException {

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
