package com.example.user_car;

import com.example.user_car.utils.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler
    public ResponseEntity<ErrorInfo> handlerException(RuntimeException exception){
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setInfo(exception.getMessage());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
