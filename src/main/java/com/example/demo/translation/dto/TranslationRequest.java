package com.example.demo.translation.dto;

import lombok.Data;

/**
 * @author Nermin Pasalic
 */
@Data
public class TranslationRequest {

    private String language;
    private String keyes;
    private String platform;
    private String value;
    private String description;
}
