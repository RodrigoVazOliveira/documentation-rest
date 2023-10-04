package dev.rodrigovaz.api.exception;

import java.time.LocalDateTime;

public class ResponseError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String status = "error";
    private final Integer statusCode;
    private final String error;

    public ResponseError(Integer statusCode, String error) {
        this.statusCode = statusCode;
        this.error = error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }
}
