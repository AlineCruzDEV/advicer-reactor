package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AdviceService {
    Mono<AdviceResponse> create(final AdviceRequest request);
    Flux<AdviceResponse> getAll();
    Mono<AdviceResponse> getById(final Long id);
    Mono<Void> delete(final Long id);
}
