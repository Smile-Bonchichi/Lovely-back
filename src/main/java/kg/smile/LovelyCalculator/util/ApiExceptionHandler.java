package kg.smile.LovelyCalculator.util;

import kg.smile.LovelyCalculator.exception.base.BaseException;
import kg.smile.LovelyCalculator.model.ExceptionResponseModel;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ExceptionResponseModel> returnedExceptionMessage(BaseException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(
                        ExceptionResponseModel.builder()
                                .message(e.getMessage())
                                .httpStatus((long) e.getHttpStatus().value())
                                .build()
                );
    }
}
