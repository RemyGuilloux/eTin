package dev.louiiuol.etin.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import dev.louiiuol.etin.controllers.dtos.responses.ApiErrorsDto;
import dev.louiiuol.etin.controllers.utils.errors.MessageNotReadableError;
import dev.louiiuol.etin.controllers.utils.errors.ValidationError;

/** <p> This class exposes a {@code RestControllerAdvice} to handle {@code ResponseEntityException}. </p>
 * @see org.springframework.web.bind.annotation.RestControllerAdvice
 * @see org.springframework.web.bind.MethodArgumentNotValidException
 * @see org.springframework.http.converter.HttpMessageNotReadableException
 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler */
@RestControllerAdvice
public abstract class ControllerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAdvice.class);

	protected ControllerAdvice() { /* Default no-arg constructor  */ }
	
    /** <p> Overriden to customize the response body in case of method with invalid argument </p>
	 * @param
	 * @return ResponseEntity<Object> */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		// Intercept field validation errors
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		List<ValidationError> errors = new ArrayList<>(fieldErrors.size());
		ValidationError error = null;
		for (FieldError fieldError : fieldErrors) {
			String entityName = fieldError.getObjectName();
			String fieldName = fieldError.getField();
			String errorCode = fieldError.getDefaultMessage();
			error = ValidationError.ofFieldType(entityName, fieldName, errorCode);
			errors.add(error);
		}
		
		// Intercept global errors such as multi-fields errors
		List<ObjectError> globalErrors = ex.getBindingResult()
			.getGlobalErrors();
		for (ObjectError globalError : globalErrors) {
			String entityName = globalError.getObjectName();
			String fieldName = globalError.getCode();
			String errorCode = globalError.getDefaultMessage();
			error = ValidationError.ofGlobalType(entityName, fieldName, errorCode);
			errors.add(error);
		}

		// Wrap Errors in response dto
		ApiErrorsDto<ValidationError> apiErrors = new ApiErrorsDto<>(errors, status.value(), getRequestURI());
		LOGGER.error("ARGUMENT NOT VALID: "  + apiErrors.toString());
		return new ResponseEntity<>(apiErrors, status);
	}

    /** <p> Overriden to customize the response body in case of HTTP message not readable.  </p>
	 * @param
	 * @return ResponseEntity<Object> */
    @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable( HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {	
		// Intercept not readable messages including conversion errors
		List<MessageNotReadableError> errors = new ArrayList<>();
		errors.add(new MessageNotReadableError(ex.getMessage()));
		ApiErrorsDto<MessageNotReadableError> apiErrors = new ApiErrorsDto<>(errors,
			status.value(), getRequestURI());
		return new ResponseEntity<>(apiErrors, status);
    }

	/** <p> Overriden to customize the response body in case of Internal Exception </p>
	 * @param
	 * @return ResponseEntity<Object> */
    @Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		// Intercept any other exceptions
		return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    /** <p> Convenient method returning the request URI. </p>
     * @return the request URI */
    protected static String getRequestURI() { 
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getRequestURI();
	}

}