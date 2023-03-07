package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserResponse> getAll();
    Mono<UserResponse> getById(final Long id);
    Mono<UserResponse> create(final UserRequest request);
    Flux<TopicResponse> getTopics(long id);

}
