package com.example.demo.translation.enumeration;

import java.util.Arrays;

import org.springframework.context.i18n.LocaleContextHolder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Edin Mahmutovic
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum LanguageEnum {

    // enum field
    EN("en", "English"),
    SI("si", "Slovenski");

    private final String code;
    private final String name;

    public static LanguageEnum getLanguageByCode(String code) {
        return Arrays.stream(LanguageEnum.values())
                .filter(language -> language.code.equalsIgnoreCase(code)).findFirst()
                .orElse(SI);
    }

    public static LanguageEnum getLanguageByLocale() {
        String lang = LocaleContextHolder.getLocale().getLanguage();
        return Arrays.stream(LanguageEnum.values())
                .filter(language -> language.code.equalsIgnoreCase(lang)).findFirst()
                .orElse(SI);
    }
}
