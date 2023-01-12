package com.example.demo.translation;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/translation")
public class TranslationController {

    @Autowired
    TranslationRepository repository;

    @GetMapping("/{id}")
    public Translation getTranslation(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @GetMapping()
    public List<Translation> getTranslationByPlatform(@RequestParam(value = "platform") String platform,
            @RequestParam(value = "language") String language) {
        return repository.findByPlatformAndLanguage(platform, language);
    }

    @PostMapping()
    public Translation postTranslation(@RequestBody Translation translation) {
        return repository.save(translation);
    }

    @PutMapping("/{id}")
    public Translation putTranslation(@PathVariable Long id, @RequestBody Translation translation) {
        Translation oldTranslation = repository.findById(id).get();
        oldTranslation.setPlatform(translation.getPlatform());
        oldTranslation.setLanguage(translation.getLanguage());
        oldTranslation.setValue(translation.getValue());
        oldTranslation.setDescription(translation.getDescription());
        oldTranslation.setAppKey(translation.getAppKey());
        return repository.save(oldTranslation);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
