package edu.miu.cs.badgeandmembershipcontrol.advice;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestAdvice {

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ErrorMessage handle(Exception e){
//        return new ErrorMessage(e.getMessage());
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
////    public ErrorMessage handle(RuntimeException e){
//    public ResponseEntity<?> handle(RuntimeException e){
//        System.out.println(e.getMessage());
////        return new ErrorMessage(e.getMessage());
//        return new ResponseEntity<>("Oops Something went wrong", HttpStatus.BAD_REQUEST);
//    }
//
//    @AllArgsConstructor
//    static class ErrorMessage{
//        private String message;
//    }

}
