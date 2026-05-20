package com.biblioteca.inclusiva.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResposta> handleResourcesNotFound (ResourceNotFoundException ex, HttpServletRequest request){

        ErrorResposta error =new ErrorResposta(LocalDateTime.now(), 404, ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity <ErrorResposta> duplicateEntryException (DuplicateEntryException ex, HttpServletRequest request){

        ErrorResposta error = new ErrorResposta(LocalDateTime.now(), 409, ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(409).body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List <String> erros = ex.getBindingResult()
                .getFieldErrors()
                .stream().map(field -> field.getField() + ": " +field.getDefaultMessage())
                .toList();

        ErrorResposta error = new ErrorResposta(LocalDateTime.now(), 400, erros.toString(), request.getContextPath());

        return ResponseEntity.status(400).body(error);
    }
}
