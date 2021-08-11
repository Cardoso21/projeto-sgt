package br.com.basis.sgt.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.basis.sgt.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(LocalDateTime.now(), status.value(), 
				"Objeto não encontrado !", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(PropertyReferenceException.class)
	public ResponseEntity<StandardError> propetiesNotFound(PropertyReferenceException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(LocalDateTime.now(), status.value(), 
				"Erro no preenchimento das propriedades contidas na url !", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException .class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException  e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ValidationError error = new ValidationError(LocalDateTime.now(), status.value(), 
				"Erro no preenchimento dos dados!", e.getMessage(), request.getRequestURI());
		for (FieldError f: e.getBindingResult().getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(error);
	}
	
	
	
}
