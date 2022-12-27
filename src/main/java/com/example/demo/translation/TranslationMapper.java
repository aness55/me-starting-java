package com.example.demo.translation;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.translation.dto.TranslationRequest;
import com.example.demo.translation.dto.TranslationResponse;

/**
 * @author Nermin Pasalic
 */
@Mapper
public interface TranslationMapper {

    TranslationMapper INSTANCE = Mappers.getMapper(TranslationMapper.class);

    /**
     * Maps request to entity
     *
     * @param request translation request model
     * @return entity translation
     */
    default Translation toEntity(TranslationRequest request) {
        var translation = new Translation();
        translation.setKey(request.getKey());
        translation.setValue(request.getValue());
        translation.setDescription(request.getDescription());
        return translation;
    }

    /**
     * Maps entity to response
     *
     * @param entity entity object
     * @return response translation response model
     */
    default TranslationResponse toResponse(Translation entity) {
        var response = new TranslationResponse();
        response.setId(entity.getId());
        response.setKey(entity.getKey());
        response.setValue(entity.getValue());
        response.setPlatform(entity.getPlatform());
        response.setDescription(entity.getDescription());
        return response;
    }
}
