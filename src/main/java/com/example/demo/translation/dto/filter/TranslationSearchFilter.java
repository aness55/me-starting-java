package com.example.demo.translation.dto.filter;

import lombok.Data;

/**
 * @author Nermin Pasalic
 */
@Data
public class TranslationSearchFilter {

    private Long id;
    private String language;
    private String keyes;
    private String value;
    private String platform;
}
