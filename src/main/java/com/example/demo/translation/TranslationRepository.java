package com.example.demo.translation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.translation.enumeration.LanguageEnum;

/**
 * @author Edin Mahmutovic
 */
public interface TranslationRepository extends JpaRepository<Translation, Long>, JpaSpecificationExecutor<Translation> {

    /**
     * Find translation by language and keyes
     *
     * @param language translation language
     * @param keyes      translation keyes
     * @return translation entity
     */
    @Query("select t from Translation t where t.language = :language and t.keyes = :keyes")
    Optional<Translation> findByLanguageAndKey(@Param("language") LanguageEnum language, @Param("keyes") String keyes);

    /**
     * Method existTranslation
     *
     * @param language translation language
     * @param keyes      transaltio keyes
     * @return flag if translation exists
     */
    @Query("select case when count(t)> 0 then true else false end from Translation t " +
            "where t.language = :language and lower(t.keyes) = lower(:keyes)")
    boolean existTranslation(@Param("language") LanguageEnum language, @Param("keyes") String keyes);
}