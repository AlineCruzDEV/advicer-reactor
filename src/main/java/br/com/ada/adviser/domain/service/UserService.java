package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserResponse> create(final UserRequest request);
    Flux<UserResponse> getAll();
}
