package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdviceService {
    Mono<AdviceResponse> create(final AdviceRequest request);
    Flux<AdviceResponse> getAll();
}
