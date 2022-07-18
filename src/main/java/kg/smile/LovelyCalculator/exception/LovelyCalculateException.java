package kg.smile.LovelyCalculator.exception;

import kg.smile.LovelyCalculator.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class LovelyCalculateException extends BaseException {
    public LovelyCalculateException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
