package com.biblioteca.inclusiva.Exception;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

public class DuplicateEntryException extends RuntimeException{
    public DuplicateEntryException(String message){
        super(message);
    }
}
