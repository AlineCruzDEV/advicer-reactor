package br.com.ada.adviser.domain.service;

import br.com.ada.adviser.web.dto.request.TopicRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TopicService {
    Flux<TopicResponse> getAll();
    Mono<TopicResponse> create(final TopicRequest request);
    Flux<UserResponse> findUserIdsByTopic(@Param("name") String name);
    Flux<UserResponse> findUserIdsByTopic(@Param("names") List<String> names);
}
