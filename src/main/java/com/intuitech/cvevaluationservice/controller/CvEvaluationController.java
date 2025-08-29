package com.intuitech.cvevaluationservice.controller;

import com.intuitech.cvevaluationservice.config.UploadProperties;
import com.intuitech.cvevaluationservice.model.dto.CvEvaluationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/cv")
public class CvEvaluationController {

    private final List<String> allowedTypes;


    public CvEvaluationController(
            UploadProperties uploadProperties) {
        this.allowedTypes = uploadProperties.getAllowedTypes();

    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CvEvaluationResponse> uploadAndEvaluateCv(
            @RequestParam("file") MultipartFile file) {



        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(CvEvaluationResponse.error("File is empty", null));
        }

        if (!allowedTypes.contains(file.getContentType())) {
            return ResponseEntity.badRequest().body(CvEvaluationResponse.error("Invalid file type!", file.getOriginalFilename()));
        }

        return ResponseEntity.ok(CvEvaluationResponse.success(file.getOriginalFilename()));
    }
}