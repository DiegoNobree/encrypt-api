package diegonobre.com.encryptapi.infraexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import diegonobre.com.encryptapi.domain.exception.OperationNotFound;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
		
	@ExceptionHandler(OperationNotFound.class)
	private ResponseEntity<String> employeeNotFound (OperationNotFound operationNotFound) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(operationNotFound.getMessage());
	}
	
}