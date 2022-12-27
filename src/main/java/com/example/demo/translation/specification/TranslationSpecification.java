package com.example.demo.translation.specification;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;
import org.springframework.util.StringUtils;

import com.example.demo.translation.Translation;
import com.example.demo.translation.dto.filter.TranslationSearchFilter;
import com.example.demo.translation.enumeration.LanguageEnum;
import com.example.demo.utils.QueryUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nermin Pasalic
 */
@AllArgsConstructor
public class TranslationSpecification implements Specification<Translation> {

    private final transient TranslationSearchFilter filter;

    @Override
    public Predicate toPredicate(@NonNull Root<Translation> root, @NonNull CriteriaQuery<?> criteriaQuery,
            @NonNull CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (filter.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
        }
        if (!StringUtils.isEmpty(filter.getKey())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("key")),
                    QueryUtils.contains(filter.getKey())));
        }
        if (!StringUtils.isEmpty(filter.getValue())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("value")),
                    QueryUtils.contains(filter.getValue())));
        }
        if (!StringUtils.isEmpty(filter.getLanguage())) {
            predicates.add(criteriaBuilder.equal(root.get("language"),
                    LanguageEnum.getLanguageByCode(filter.getLanguage())));
        }

        if (!StringUtils.isEmpty(filter.getPlatform())) {
            predicates.add(criteriaBuilder.equal(root.get("platform"),
                    QueryUtils.contains(filter.getPlatform())));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
