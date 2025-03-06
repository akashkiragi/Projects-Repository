package com.bank.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bank.project.dto.ErrorDTO;
import com.bank.project.dto.ResponseDTO;


@ControllerAdvice
public class GlobalExceptionHandler  {	

	@ExceptionHandler(AccountHandleException.class)
    public ResponseEntity<ResponseDTO> handleAccountNotFoundException(AccountHandleException exception) {
		ErrorDTO errorDto = new ErrorDTO( exception.getStatus().toString(),  exception.getMessage());
		ResponseDTO<ErrorDTO> errorResponse = new ResponseDTO<ErrorDTO>(
				 exception.getStatus().value(),
                errorDto,
                java.time.ZonedDateTime.now().toString()
        );
        return new ResponseEntity<>(errorResponse, exception.getStatus());
	}
	
}


