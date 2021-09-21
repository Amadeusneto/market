package br.com.amadeus.marketplace.exception;

import br.com.amadeus.marketplace.dto.response.MarketplaceBaseResponse;
import br.com.amadeus.marketplace.exception.message.MarketplaceBaseMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class MarketplaceGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final MarketplaceBaseMessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (MarketplaceBaseException.class.isAssignableFrom(e.getClass())) {
            return handleException(((MarketplaceBaseException) e).error(), e.getMessage(), e);
        }

        return handleException(MarketplaceErrors.SERVER_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(MarketplaceNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundCommunicationException(MarketplaceNotFoundException e, WebRequest request) {
        return handleException(MarketplaceErrors.MARKETPLACE_NOT_FOUND, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(MarketplaceErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(MarketplaceErrors.METHOD_NOT_ALLOWED_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        return handleException(MarketplaceErrors.NOT_FOUND_ERROR, e.getMessage(), e);
    }

    private ResponseEntity<Object> handleException(MarketplaceErrors error, String message, Exception e) {
        return handleException(error, new Object[]{message}, e);
    }

    private ResponseEntity<Object> handleException(MarketplaceErrors error, Object[] params, Exception e) {
        String message = messageSource.getMessage(error, params);
        logger.error(message, e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(MarketplaceBaseResponse.notOk(error.getCode(), message, error.getDetails()));
    }

    private ResponseEntity<Object> handleException(MarketplaceErrors error, List<MarketplaceBaseResponse.Error> errors, Exception e) {
        logger.error("Error", e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(MarketplaceBaseResponse.notOk(errors));
    }

}
