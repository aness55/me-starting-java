package com.example.demo.translation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.translation.dto.TranslationRequest;
import com.example.demo.translation.dto.TranslationResponse;
import com.example.demo.translation.dto.filter.TranslationSearchFilter;
import com.example.demo.translation.specification.TranslationSpecification;

/**
 * @author Edin Mahmutovic
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TranslationService {

    private final TranslationRepository translationRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public TranslationResponse createTranslation(TranslationRequest request) {
        log.debug("[TranslationService].[createTranslation].[StaffId = {}] request : {}", request);
        var translation = TranslationMapper.INSTANCE.toEntity(request);
        translationRepository.save(translation);
        return TranslationMapper.INSTANCE.toResponse(translation);
    }

    public Page<TranslationResponse> retrieveAllTranslations(TranslationSearchFilter filter, Pageable pageable) {
        log.debug("[TranslationService].[retrieveAllTranslations].[StaffId = {}] by filter : {}",
                filter);
        return translationRepository.findAll(new TranslationSpecification(filter), pageable)
                .map(TranslationMapper.INSTANCE::toResponse);
    }

    public Page<TranslationResponse> getTranslations(TranslationSearchFilter filter, Pageable pageable) {
        log.debug("[TranslationService].[retrieveAllTranslations].[StaffId = {}] by filter : {}",
                filter);
        return translationRepository.findAll(new TranslationSpecification(filter), pageable)
                .map(TranslationMapper.INSTANCE::toResponse);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteTranslation(Long id) {
        log.debug("[TranslationService].[deleteTranslation].[StaffId = {}] by ID : {}", id);
        translationRepository.deleteById(id);
    }

    

}
