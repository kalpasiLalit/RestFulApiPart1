package com.RestFulApiWebService.part1.Exception;

import com.RestFulApiWebService.part1.Error.ErrorPage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandlerClass extends ResponseEntityExceptionHandler {

     @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception{
        ErrorPage error = new ErrorPage(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorPage error1 = new ErrorPage(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
        return new ResponseEntity<>(error1,HttpStatus.NOT_FOUND);
    }

}
