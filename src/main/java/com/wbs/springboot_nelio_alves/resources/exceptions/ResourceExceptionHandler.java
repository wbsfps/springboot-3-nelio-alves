package com.wbs.springboot_nelio_alves.resources.exceptions;

import com.wbs.springboot_nelio_alves.services.exceptions.DatabaseException;
import com.wbs.springboot_nelio_alves.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError stantardError = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(stantardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException databaseException, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError stantardError = new StandardError(Instant.now(), status.value(), error, databaseException.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(stantardError);
    }
}
