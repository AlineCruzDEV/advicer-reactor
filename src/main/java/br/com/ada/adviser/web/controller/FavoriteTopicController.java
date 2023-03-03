package br.com.ada.adviser.web.controller;

import br.com.ada.adviser.domain.service.FavoriteTopicService;
import br.com.ada.adviser.web.dto.request.FavoriteTopicRequest;
import br.com.ada.adviser.web.dto.response.FavoriteTopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class FavoriteTopicController {

    @Autowired
    private FavoriteTopicService service;

    @GetMapping
    public ResponseEntity<Flux<FavoriteTopicResponse>> getAll() {
        final Flux<FavoriteTopicResponse> topics = service.getAll();
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public Mono<ResponseEntity<FavoriteTopicResponse>> create(@RequestBody FavoriteTopicRequest request) {
        final Mono<FavoriteTopicResponse> createdTopic = service.create(request);
        return createdTopic.map(
                topic -> ResponseEntity.created(URI.create("/topics/" + topic.getId())).body(topic)
        );
    }

}
