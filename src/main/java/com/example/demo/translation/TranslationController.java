package com.example.demo.translation;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.translation.dto.TranslationResponse;
import com.example.demo.translation.dto.filter.TranslationSearchFilter;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.List;

@RestController
@RequestMapping({ "/mobile/v1/translations", "/e-banking/v1/translations" })
@RequiredArgsConstructor
public class TranslationController {

    private final TranslationService translationService;

    @GetMapping
    public ResponseEntity<List<TranslationResponse>> findAll(
            TranslationSearchFilter filter,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<TranslationResponse> translations = translationService.retrieveAllTranslations(filter, pageable);
        return ResponseEntity.ok().body(translations.getContent());
    }
}
