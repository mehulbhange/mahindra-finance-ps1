package com.leadservice.leadservice.exceptions;

import com.leadservice.leadservice.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class LeadsExceptionHandler {

    @ExceptionHandler(LeadAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleLeadAlreadyExistsException(LeadAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.OK).body(ex.getErrorResponse());
    }

    @ExceptionHandler(LeadsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLeadsNotFoundException(LeadsNotFoundException ex){
        return ResponseEntity.status(HttpStatus.OK).body(ex.getErrorResponse());
    }

}
