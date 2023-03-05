package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.TopicRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TopicService {
    Flux<TopicResponse> getAll();
    Mono<TopicResponse> create(final TopicRequest request);
}
