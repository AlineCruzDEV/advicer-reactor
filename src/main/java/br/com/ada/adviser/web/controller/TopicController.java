package br.com.ada.adviser.web.controller;

import br.com.ada.adviser.domain.service.TopicService;
import br.com.ada.adviser.web.dto.request.TopicRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService service;

    @GetMapping
    public ResponseEntity<Flux<TopicResponse>> getAll() {
        final Flux<TopicResponse> topics = service.getAll();
        return ResponseEntity.ok(topics);
    }

    @PostMapping
    public Mono<ResponseEntity<TopicResponse>> create(@RequestBody TopicRequest request) {
        final Mono<TopicResponse> createdTopic = service.create(request);
        return createdTopic.map(
                topic -> ResponseEntity.created(URI.create("/topics/" + topic.getId())).body(topic)
        );
    }

}
