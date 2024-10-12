package com.dietbuilder.rest.error;

import com.dietbuilder.rest.error.models.SqlErrorResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {SQLIntegrityConstraintViolationException.class})
    protected ResponseEntity<Object> handleConflict(SQLIntegrityConstraintViolationException ex, WebRequest request) {

        SqlErrorResponseModel body = SqlErrorResponseModel.builder()
                .title(getTitle(ex.getMessage()))
                .detailedMessage(ex.getMessage())
                .sqlState(ex.getSQLState())
                .build();

        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private String getTitle(String message) {
        return message.replaceFirst(":[\\s\\S]*", "");
    }

}
