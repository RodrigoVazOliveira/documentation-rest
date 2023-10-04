package dev.rodrigovaz.api.exception;

import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.UndeclaredThrowableException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders getHeaders() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return httpHeaders;
    }

    private ResponseError createResponseError(final String message, final HttpStatus httpStatus) {
        return new ResponseError(httpStatus.value(), message);
    }

    @ExceptionHandler({Exception.class})
    ResponseEntity<Object> handlerGeneral(Exception exception, WebRequest webRequest) {
        if (exception.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
            UndeclaredThrowableException undeclaredThrowableException = (UndeclaredThrowableException) exception;

            return handlerBusinessException((BusinessException) undeclaredThrowableException.getUndeclaredThrowable(), webRequest);
        }

        final String message = messageSource.getMessage("error.server", new Object[]{exception.getMessage()}, null);
        final ResponseError responseError = createResponseError(message, HttpStatus.INTERNAL_SERVER_ERROR);

        return handleExceptionInternal(exception, responseError, getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
    }

    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> handlerBusinessException(BusinessException businessException, WebRequest webRequest) {
        final ResponseError responseError = createResponseError(businessException.getMessage(), HttpStatus.CONFLICT);

        return handleExceptionInternal(businessException, responseError, getHeaders(), HttpStatus.CONFLICT, webRequest);
    }
}
