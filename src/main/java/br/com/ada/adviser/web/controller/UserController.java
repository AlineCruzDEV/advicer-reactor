package br.com.ada.adviser.web.controller;

import br.com.ada.adviser.domain.service.UserService;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.TopicResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Flux<UserResponse>> getAll() {
        final Flux<UserResponse> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public Mono<UserResponse> getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Mono<ResponseEntity<UserResponse>> create(@RequestBody UserRequest request) {
        final Mono<UserResponse> createdUser = service.create(request);
        return createdUser.map(
                user -> ResponseEntity.created(URI.create("/users/" + user.getId())).body(user)
        );
    }

    @GetMapping("/{id}/topics")
    public ResponseEntity<Flux<TopicResponse>> getTopics(@PathVariable("id") Long id) {
        final Flux<TopicResponse> topics = service.getTopics(id);
        return ResponseEntity.ok(topics);
    }

}
