package com.example.demo.translation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findByPlatformAndLanguage(@Param("platform") String platform, @Param("language") String language);
}
