package top.treegrowth.provider.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.treegrowth.provider.serviceImpl.exception.*;

import javax.servlet.http.HttpServletRequest;

import static top.treegrowth.provider.serviceImpl.exception.ErrorInfo.*;

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
        } else if (exception instanceof IdentifyCodeAlreadyExistException){
            errorInfo.setCode(ALREADY_EXIST);
        } else {
            errorInfo.setCode(ERROR);
        }
        errorInfo.setMessage(exception.getMessage());
        errorInfo.setUrl(req.getRequestURL().toString());
        return errorInfo;
    }
}
