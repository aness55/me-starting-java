package com.example.demo.translation.dto;


import lombok.Data;

/**
 * @author Nermin Pasalic
 */
@Data
public class TranslationResponse {
    private Long id;
    private String language;
    private String keyes;
    private String description;
    private String value;
    private String platform;
}
