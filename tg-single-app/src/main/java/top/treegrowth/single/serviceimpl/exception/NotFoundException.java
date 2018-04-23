package top.treegrowth.single.serviceimpl.exception;

/**
 * @author wusi
 * @version 2017/2/23 21:58.
 */
public class NotFoundException extends ServiceException {

    private static final long serialVersionUID = 2680817321539443820L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
