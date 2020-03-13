package com.flchy.cloud.xss.holder;



import com.flchy.cloud.enums.BaseEWarning;
import com.flchy.cloud.exception.BusinessException;
import com.flchy.cloud.response.ResponseResult;
import com.flchy.cloud.utils.ValidateUtil;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: controller全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected final org.slf4j.Logger log = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object handle(BusinessException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        StackTraceElement stack = stackTrace[0];
        log.info(e.getMessage());
        log.info("exception in：{} {}(),line:{}", stack.getClassName(), stack.getMethodName(), stack.getLineNumber());
        // 业务失败返回
        return new ResponseResult(e.getWarning());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object allExceptionHandler(Exception exception) {
        exception.printStackTrace();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        StackTraceElement stack = stackTrace[0];
        log.error(exception.getMessage());
        log.error("exception in：{} {}(),line:{}", stack.getClassName(), stack.getMethodName(), stack.getLineNumber());
        //TODO 自定义操作
        return new ResponseResult(BaseEWarning.SYSTEM_BUSY);
    }

    /**
     * Bean 校验异常
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object notValidExceptionHandler(MethodArgumentNotValidException e) throws Exception {
        log.info("exception in：{}", e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        String message = e.getMessage();
        if (bindingResult != null) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            if (ValidateUtil.collectionNotEmpty(errorList)) {
                message = errorList.get(0).getDefaultMessage();
            }
        }
        return new ResponseResult(BaseEWarning.ErrorParams, message);
    }
}
