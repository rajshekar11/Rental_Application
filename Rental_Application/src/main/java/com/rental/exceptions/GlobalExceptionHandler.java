package com.rental.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetails> bookingExceptionHandler(BookingException be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LandLordException.class)
	public ResponseEntity<MyErrorDetails> landLordExceptionHandler(LandLordException be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PropertyException.class)
	public ResponseEntity<MyErrorDetails> propertyExceptionHandler(PropertyException be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TenantException.class)
	public ResponseEntity<MyErrorDetails> tenantExceptionHandler(TenantException be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> globalExceptionHandler(Exception be,WebRequest wr){
		MyErrorDetails me=new MyErrorDetails();
		me.setMessage(be.getMessage());
		me.setTimestamp(LocalDateTime.now());
		me.setDescription(wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(me,HttpStatus.BAD_REQUEST);
	}
}
