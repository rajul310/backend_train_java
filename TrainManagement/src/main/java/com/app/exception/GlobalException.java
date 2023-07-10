package com.app.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.customException.NotFoundException;
import com.app.dto.ApiResponseDTO;

@RestControllerAdvice
public class GlobalException {


	
	

		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
			
			Map<String, String> map = new HashMap<>();
			for (FieldError f : e.getFieldErrors())
				map.put(f.getField(), f.getDefaultMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}
		
		@ExceptionHandler(NotFoundException.class)
		public ResponseEntity<?> handleCourseCustomException(NotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponseDTO(e.getMessage()));
		}
		
		
		@ExceptionHandler(Exception.class)
	    public ResponseEntity<ApiResponseDTO> handleInternalServerError(Exception ex) {
	        // Create an instance of ApiResponseDTO with the error message
	        ApiResponseDTO errorResponse = new ApiResponseDTO("Internal Server Error");
	        
	        // You can also log the exception here
	        
	        // Return ResponseEntity with the error response and appropriate HTTP status
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    
		
	}

}
