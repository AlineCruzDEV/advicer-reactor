package br.com.ada.adviser.domain.service.impl;

import br.com.ada.adviser.domain.entity.AdviceEntity;
import br.com.ada.adviser.domain.repository.AdviceRepository;
import br.com.ada.adviser.domain.service.AdviceService;
import br.com.ada.adviser.domain.utils.AdviceConvertUtils;
import br.com.ada.adviser.infra.topics.AdviceTopicHandler;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
public class AdviceServiceImpl implements AdviceService {

    private AdviceRepository repository;
    private AdviceTopicHandler adviceTopicHandler;
    public AdviceServiceImpl(final AdviceRepository repository, final AdviceTopicHandler adviceTopicHandler) {
        this.repository = repository;
        this.adviceTopicHandler = adviceTopicHandler;
    }

    public Flux<AdviceResponse> getAll(){
        final Flux<AdviceEntity> advicesFlux = repository.findAll();
        return advicesFlux.map(AdviceConvertUtils::toResponse);
    }

    @Override
    public Mono<AdviceResponse> getById(Long id) {
        return repository.findById(id).map(AdviceConvertUtils::toResponse);
    }

    public Mono<AdviceResponse> create(final AdviceRequest request){
        final AdviceEntity entity = AdviceConvertUtils.toEntity(request);
        final Mono<AdviceResponse> adviceResponseMono = repository.save(entity).map(AdviceConvertUtils::toResponse);

        adviceResponseMono
                .subscribeOn(Schedulers.newSingle("New advice"))
                    .subscribe(adviceTopicHandler::sendNotification);

        return adviceResponseMono;
    }

    public Mono<Void> delete(@PathVariable("id") Long id) {
        return repository.deleteById(id);
    }

}
