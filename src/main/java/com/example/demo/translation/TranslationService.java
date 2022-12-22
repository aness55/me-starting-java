package com.example.demo.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TranslationService {
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public List<Translation> getTranslations() {
        return translationRepository.findAll();
    }

    public void saveTranslation(Translation translation) {
        translationRepository.save(translation);
    }    

}
