package top.treegrowth.provider.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.treegrowth.provider.serviceImpl.exception.ErrorInfo;
import top.treegrowth.provider.serviceImpl.exception.ForbiddenException;
import top.treegrowth.provider.serviceImpl.exception.NotFoundException;
import top.treegrowth.provider.serviceImpl.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

import static top.treegrowth.provider.serviceImpl.exception.ErrorInfo.ERROR;
import static top.treegrowth.provider.serviceImpl.exception.ErrorInfo.FORBIDDEN;
import static top.treegrowth.provider.serviceImpl.exception.ErrorInfo.NOT_FOUND;

/**
 * @author wusi
 * @version 2017/2/23 21:49.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = ServiceException.class)
    @ResponseBody
    public ErrorInfo jsonErrorHandler(HttpServletRequest req, ServiceException exception) throws Exception {
        ErrorInfo errorInfo = new ErrorInfo();
        if (exception instanceof ForbiddenException) {
            errorInfo.setCode(FORBIDDEN);
        } else if (exception instanceof NotFoundException) {
            errorInfo.setCode(NOT_FOUND);
        } else {
            errorInfo.setCode(ERROR);
        }
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }
}
