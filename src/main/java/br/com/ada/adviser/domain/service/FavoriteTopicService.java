package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.FavoriteTopicRequest;
import br.com.ada.adviser.web.dto.response.FavoriteTopicResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FavoriteTopicService {
    Flux<FavoriteTopicResponse> getAll();
    Mono<FavoriteTopicResponse> create(final FavoriteTopicRequest request);
}
