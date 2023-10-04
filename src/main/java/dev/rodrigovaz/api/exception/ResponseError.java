package dev.rodrigovaz.api.exception;

import java.time.LocalDateTime;

public class ResponseError {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String status = "error";
    private final Integer statusCode = 400;
    private final String error;

    public ResponseError(String error) {
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
