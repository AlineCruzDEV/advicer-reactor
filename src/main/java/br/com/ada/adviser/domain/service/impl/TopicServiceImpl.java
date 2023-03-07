package br.com.ada.adviser.domain.service.impl;

import br.com.ada.adviser.domain.entity.TopicEntity;
import br.com.ada.adviser.domain.entity.UserEntity;
import br.com.ada.adviser.domain.repository.TopicRepository;
import br.com.ada.adviser.domain.repository.UserRepository;
import br.com.ada.adviser.domain.service.TopicService;
import br.com.ada.adviser.domain.service.UserService;
import br.com.ada.adviser.domain.utils.TopicConvertUtils;
import br.com.ada.adviser.domain.utils.UserConvertUtils;
import br.com.ada.adviser.web.dto.request.TopicRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private UserRepository userRepository;

    private TopicRepository repository;
    private UserService userService;
    public TopicServiceImpl(final TopicRepository repository, final UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Flux<TopicResponse> getAll() {
        final Flux<TopicEntity> topicsFlux = repository.findAll();
        return topicsFlux.map(TopicConvertUtils::toResponse);
    }

    public Mono<TopicResponse> create(final TopicRequest request) {
        final TopicEntity entity = TopicConvertUtils.toEntity(request);
        final Mono<TopicEntity> createdEntity = repository.save(entity);
        return createdEntity.map(TopicConvertUtils::toResponse);
    }

    @Override
    public Flux<UserResponse> findUserIdsByTopic(String name) {
        final Flux<Long> userIds = repository.findUserIdsByTopic(name);
        userIds.log().subscribe(id -> System.out.print(id + ", "));
//       Flux<UserEntity> userEntityFlux = userIds.map(
//            id -> {
//                    final Mono<UserEntity> userEntity = userRepository.findById(id);
//            },
//            error -> log.error("Error " + error)
//        );
        final Flux<UserEntity> userEntityFlux2 = userIds.map(UserConvertUtils::toResponse);
        return null;
    }

}
