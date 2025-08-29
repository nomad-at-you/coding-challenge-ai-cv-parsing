package com.intuitech.cvevaluationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "app.upload")
public class UploadProperties {
    private List<String> allowedTypes;
    private String allowedTypesDescription;
    private long maxFileSize;

    // Getters and setters
    public List<String> getAllowedTypes() { return allowedTypes; }
    public void setAllowedTypes(List<String> allowedTypes) { this.allowedTypes = allowedTypes; }

    public String getAllowedTypesDescription() { return allowedTypesDescription; }
    public void setAllowedTypesDescription(String description) { this.allowedTypesDescription = description; }

    public long getMaxFileSize() { return maxFileSize; }
    public void setMaxFileSize(long maxFileSize) { this.maxFileSize = maxFileSize; }
}