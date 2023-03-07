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

import java.util.Collection;
import java.util.List;

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
        //userIds.log().subscribe(System.out::print);
        Flux<UserEntity> userEntityFlux = this.getUsers(userIds);
        return userEntityFlux.map(UserConvertUtils::toResponse);
    }

    @Override
    public Flux<UserResponse> findUserIdsByTopic(List<String> names) {
        final Flux<Long> userIds = repository.findUserIdsByTopics(names);
        //userIds.log().subscribe(System.out::print);
        Flux<UserEntity> userEntityFlux = this.getUsers(userIds);
        return userEntityFlux.map(UserConvertUtils::toResponse);
    }

    private Flux<UserEntity> getUsers(Flux<Long> userIds) {
        return userIds.flatMap(id -> userRepository.findById(id));
    }

}
