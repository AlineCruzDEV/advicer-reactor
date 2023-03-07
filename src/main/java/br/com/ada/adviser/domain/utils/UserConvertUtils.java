package br.com.ada.adviser.domain.utils;

import br.com.ada.adviser.domain.entity.UserEntity;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.UserResponse;

public class UserConvertUtils {

    public static UserResponse toResponse(final UserEntity entity) {
        final UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
//        response.setTopics(
//                entity.getTopics().stream().map(FavoriteTopicConvertUtils::toResponse)
//                .collect(Collectors.toList()));
        return  response;
    }

    public static UserEntity toEntity(final UserRequest request) {
        final UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        return entity;
    }

    public static UserEntity toEntity(final UserResponse response) {
        final UserEntity entity = new UserEntity();
        entity.setId(response.getId());
        entity.setName(response.getName());
        entity.setEmail(response.getEmail());
        return entity;
    }

    public static UserEntity toResponse(final Long userId) {
        final UserEntity entity = new UserEntity();
        entity.setId(entity.getId());
        return entity;
    }

//    public static UserEntity toEntity(final UserIdRequest request) {
//        final UserEntity entity = new UserEntity();
//        entity.setName(request.getName());
//        entity.setEmail(request.getEmail());
//        return entity;
//    }

}