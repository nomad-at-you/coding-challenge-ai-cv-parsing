package com.intuitech.cvevaluationservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

/**
 * Simple response DTO for CV evaluation file upload endpoint. Returns basic status confirmation for
 * uploaded files.
 */
public class CvEvaluationResponse {

  @JsonProperty("status")
  private String status;

  @JsonProperty("message")
  private String message;

  @JsonProperty("filename")
  private String filename;

  @JsonProperty("uploaded_at")
  private LocalDateTime uploadedAt;

  // Default constructor
  public CvEvaluationResponse() {
    this.uploadedAt = LocalDateTime.now();
  }

  // Constructor for successful upload
  public CvEvaluationResponse(String filename) {
    this();
    this.status = "ok";
    this.message = "File uploaded successfully";
    this.filename = filename;
  }

  // Constructor for error cases
  public CvEvaluationResponse(String status, String message, String filename) {
    this();
    this.status = status;
    this.message = message;
    this.filename = filename;
  }

  // Getters and Setters
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public LocalDateTime getUploadedAt() {
    return uploadedAt;
  }

  public void setUploadedAt(LocalDateTime uploadedAt) {
    this.uploadedAt = uploadedAt;
  }

  // Convenience methods
  public boolean isSuccess() {
    return "success".equals(status);
  }

  public static CvEvaluationResponse success(String filename) {
    CvEvaluationResponse response = new CvEvaluationResponse();
    response.setStatus("success");
    response.setMessage("CV uploaded!");
    response.setFilename(filename);
    return response;
  }

  public static CvEvaluationResponse error(String errorMessage, String filename) {
    CvEvaluationResponse response = new CvEvaluationResponse();
    response.setStatus("error");
    response.setMessage(errorMessage);
    response.setFilename(filename);
    return response;
  }
}