package com.example.kunal.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.kunal.DTO.BadRequestError;
import com.example.kunal.DTO.ErrorMessage;
import com.example.kunal.Exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

	
@org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ResponseEntity<ErrorMessage>  handleNotFoundException(EmployeeNotFoundException e) {
	ErrorMessage error=new ErrorMessage();
	error.setStatus(HttpStatus.NOT_FOUND.toString());
	error.setMessage(e.getMessage());
	return new ResponseEntity<ErrorMessage>(error,HttpStatus.NOT_FOUND);
}

@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<BadRequestError> handleBadRequestException(MethodArgumentNotValidException e){
	BadRequestError error=new BadRequestError();
	Map<String ,String> res=new HashMap<String ,String>();
	error.setStatus(HttpStatus.BAD_REQUEST.toString());
	e.getBindingResult().getAllErrors().forEach(err->{
		res.put(((FieldError)(err)).getField(),err.getDefaultMessage());
	});
	error.setBody(res);
	return new ResponseEntity<BadRequestError>(error,HttpStatus.BAD_REQUEST);
}
	
}



