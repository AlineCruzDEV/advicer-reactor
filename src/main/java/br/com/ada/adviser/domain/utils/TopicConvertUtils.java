package br.com.ada.adviser.domain.utils;

import br.com.ada.adviser.domain.entity.TopicEntity;
import br.com.ada.adviser.web.dto.request.TopicRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;

public class TopicConvertUtils {

    public static TopicResponse toResponse(final TopicEntity entity) {
        final TopicResponse response = new TopicResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUserId(entity.getUserId());
        return  response;
    }

    public static TopicEntity toEntity(final TopicRequest request) {
        final TopicEntity entity = new TopicEntity();
        entity.setName(request.getName());
        entity.setUserId(request.getUserId());
        return entity;
    }

}