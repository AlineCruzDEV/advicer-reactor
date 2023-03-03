package br.com.ada.adviser.domain.utils;

import br.com.ada.adviser.domain.entity.FavoriteTopicEntity;
import br.com.ada.adviser.web.dto.request.FavoriteTopicRequest;
import br.com.ada.adviser.web.dto.response.FavoriteTopicResponse;

public class FavoriteTopicConvertUtils {

    public static FavoriteTopicResponse toResponse(final FavoriteTopicEntity entity) {
        final FavoriteTopicResponse response = new FavoriteTopicResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        return  response;
    }
    public static FavoriteTopicEntity toEntity(final FavoriteTopicRequest request) {
        final FavoriteTopicEntity entity = new FavoriteTopicEntity();
        entity.setName(request.getName());
        return entity;
    }

}