package br.com.ada.adviser.domain.service.impl;

import br.com.ada.adviser.domain.entity.TopicEntity;
import br.com.ada.adviser.domain.entity.UserEntity;
import br.com.ada.adviser.domain.repository.UserRepository;
import br.com.ada.adviser.domain.service.TopicService;
import br.com.ada.adviser.domain.service.UserService;
import br.com.ada.adviser.domain.utils.TopicConvertUtils;
import br.com.ada.adviser.domain.utils.UserConvertUtils;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    public Flux<UserResponse> getAll() {
        final Flux<UserEntity> usersFlux = repository.findAll();
        return usersFlux.map(UserConvertUtils::toResponse);
    }

    public Mono<UserResponse> getById(final Long id) {
        return repository.findById(id).map(UserConvertUtils::toResponse);
    }

    public Mono<UserResponse> create(final UserRequest request) {
        final UserEntity entity = UserConvertUtils.toEntity(request);
        final Mono<UserEntity> createdEntity = repository.save(entity);
        return createdEntity.map(UserConvertUtils::toResponse);
    }

    @Override
    public Flux<TopicResponse> getTopics(long id) {
        final Flux<TopicEntity> topicsFlux = repository.getTopics(id);
        return topicsFlux.map(TopicConvertUtils::toResponse);
    }

}
