package com.kaly7dev.backendblogapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
@Slf4j
public class BlogExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PostNotFoundException.class)
    ProblemDetail handleBackendBlogException(PostNotFoundException postNotFoundException){
        ProblemDetail problemDetail=
                ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, postNotFoundException.getMessage());
        problemDetail.setTitle("Blog Post Not Found !");
        problemDetail.setProperty("errorCategory","Generic");
        problemDetail.setProperty("timestamp", Instant.now());

        log.info("Blog Post Exception Propagated ! ");
        return problemDetail;
    }
}
