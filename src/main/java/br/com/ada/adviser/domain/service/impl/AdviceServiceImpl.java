package br.com.ada.adviser.domain.service.impl;

import br.com.ada.adviser.domain.entity.AdviceEntity;
import br.com.ada.adviser.domain.repository.AdviceRepository;
import br.com.ada.adviser.domain.service.AdviceService;
import br.com.ada.adviser.domain.utils.AdviceConvertUtils;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AdviceServiceImpl implements AdviceService {

    private AdviceRepository repository;
    public AdviceServiceImpl(final AdviceRepository repository) {
        this.repository = repository;
    }

    public Mono<AdviceResponse> create(final AdviceRequest request){
        final AdviceEntity entity = AdviceConvertUtils.toEntity(request);
        final Mono<AdviceEntity> createdEvent = repository.save(entity);
        return createdEvent.map(AdviceConvertUtils::toResponse);
    }

    public Flux<AdviceResponse> getAll(){
        final Flux<AdviceEntity> advicesFlux = repository.findAll();
        return advicesFlux.map(AdviceConvertUtils::toResponse);
    }

}
