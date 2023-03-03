package br.com.ada.adviser.domain.utils;

import br.com.ada.adviser.domain.entity.AdviceEntity;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;

public class AdviceConvertUtils {

    public static AdviceResponse toResponse(final AdviceEntity entity) {
        final AdviceResponse response = new AdviceResponse();
        response.setId(entity.getId());
        response.setAdvice(entity.getAdvice());
        return  response;
    }
    public static AdviceEntity toEntity(final AdviceRequest request) {
        final AdviceEntity entity = new AdviceEntity();
        entity.setAdvice(request.getAdvice());
        return entity;
    }

}