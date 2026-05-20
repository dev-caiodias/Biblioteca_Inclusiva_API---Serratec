package com.biblioteca.inclusiva.Exception;

import java.time.LocalDateTime;

public class ErrorResposta {

    private LocalDateTime timestamp; //momento em que o erro apareceu
    private int status; //Código do http
    private String message;//mensagem falando do erro
    private String path;//url que causou o erro

    public ErrorResposta(LocalDateTime timestamp, int status, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }
}
