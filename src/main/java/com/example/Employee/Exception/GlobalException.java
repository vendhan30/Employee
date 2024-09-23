package com.example.Employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(EmptyException.class)
public ResponseEntity<Object> empty(EmptyException ee) {
	return new ResponseEntity<>("Object Not Found", HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(MinorException.class)
public ResponseEntity<Object> getminor(MinorException me) {
	return new ResponseEntity<>("Object not found", HttpStatus.NOT_FOUND);

}
}
