package xin.kingsman.validatordemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


/**
 * @author songhao
 */
@Slf4j
@RestControllerAdvice
public class BadRequestExceptionHandler {


    /**
     * 校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        log.error("出错了",e);
        return "error";
    }


    /**
     * 校验异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = BindException.class)
    public String handleException(BindException e) {
        log.error("出错了",e);
        BindingResult result = e.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        StringBuilder errorInfo = new StringBuilder();
        for (FieldError error : errors) {
            errorInfo.append(error.getField());
            errorInfo.append(error.getDefaultMessage());
            errorInfo.append(";");
        }
        return errorInfo.toString();
    }


}