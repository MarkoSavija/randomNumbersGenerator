package com.randomNumbers.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetails> handleAnyException(final Exception ex,
      final WebRequest request) {

    // @formatter:off
    final ErrorDetails errorDetails = new ErrorDetails(
            System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getDescription(false),
            "Internal Server Error", ex.getMessage(), null);

    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {ValidationException.class, MethodArgumentTypeMismatchException.class,
      MissingServletRequestParameterException.class, IllegalArgumentException.class,
      IllegalStateException.class, HttpMessageNotReadableException.class})
  public ResponseEntity<ErrorDetails> handleInvalidRequest(final RuntimeException ex,
      final WebRequest request) {

    final ErrorDetails errorDetails = new ErrorDetails(
            System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), request.getDescription(false),
            "Invalid request", ex.getMessage(), null);

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDetails> handleInvalidRequest(final MethodArgumentNotValidException ex,
      final WebRequest request) {

    final String errorTemplate = "Invalid field: %s, reason: %s, rejected value: %s;";

    final List<String> causes = ex.getBindingResult().getFieldErrors().stream()
        .map(e -> String.format(errorTemplate, e.getField(), e.getDefaultMessage(), e.getRejectedValue()))
        .collect(Collectors.toList());

    final ErrorDetails errorDetails = new ErrorDetails(
            System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), request.getDescription(false),
            "Invalid request", "Your request has validation errors", causes);

    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }


}
