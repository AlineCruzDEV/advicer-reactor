package br.com.ada.adviser.domain.utils;

import br.com.ada.adviser.domain.entity.AdviceEntity;
import br.com.ada.adviser.domain.entity.UserEntity;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;

public class UserConvertUtils {

    public static UserResponse toResponse(final UserEntity entity) {
        final UserResponse response = new UserResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        return  response;
    }
    public static UserEntity toEntity(final UserRequest request) {
        final UserEntity entity = new UserEntity();
        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        return entity;
    }

}