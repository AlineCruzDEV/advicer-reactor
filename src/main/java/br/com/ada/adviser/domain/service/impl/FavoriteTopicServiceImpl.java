package br.com.ada.adviser.domain.service.impl;

import br.com.ada.adviser.domain.entity.FavoriteTopicEntity;
import br.com.ada.adviser.domain.repository.FavoriteTopicRepository;
import br.com.ada.adviser.domain.service.FavoriteTopicService;
import br.com.ada.adviser.domain.utils.FavoriteTopicConvertUtils;
import br.com.ada.adviser.web.dto.request.FavoriteTopicRequest;
import br.com.ada.adviser.web.dto.response.FavoriteTopicResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FavoriteTopicServiceImpl implements FavoriteTopicService {

    private FavoriteTopicRepository repository;
    public FavoriteTopicServiceImpl(final FavoriteTopicRepository repository) {
        this.repository = repository;
    }

    public Flux<FavoriteTopicResponse> getAll() {
        final Flux<FavoriteTopicEntity> favoriteTopicsFlux = repository.findAll();
        return favoriteTopicsFlux.map(FavoriteTopicConvertUtils::toResponse);
    }

    public Mono<FavoriteTopicResponse> create(final FavoriteTopicRequest request) {
        final FavoriteTopicEntity entity = FavoriteTopicConvertUtils.toEntity(request);
        final Mono<FavoriteTopicEntity> createdEntity = repository.save(entity);
        return createdEntity.map(FavoriteTopicConvertUtils::toResponse);
    }

}
