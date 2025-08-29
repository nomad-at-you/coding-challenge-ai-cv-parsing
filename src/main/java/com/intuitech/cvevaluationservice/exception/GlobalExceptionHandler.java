package com.intuitech.cvevaluationservice.exception;

import com.intuitech.cvevaluationservice.model.dto.CvEvaluationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<CvEvaluationResponse> handleMaxSizeException(MaxUploadSizeExceededException exc) {
        logger.warn("File upload size exceeded: {}", exc.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(CvEvaluationResponse.error(
                        "File size exceeds the maximum allowed limit of 5MB. Please upload a smaller file.",
                        null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CvEvaluationResponse> handleGenericException(Exception exc) {
        logger.error("Unexpected error occurred: {}", exc.getMessage(), exc);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CvEvaluationResponse.error(
                        "An unexpected error occurred. Please try again later.",
                        null));
    }
}