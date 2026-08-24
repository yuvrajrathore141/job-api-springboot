package com.yuvraj.jobapi.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp.now();
    }
    public String getMessage() {
        return message;
    }
    public int getStatus() {
        return status;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
