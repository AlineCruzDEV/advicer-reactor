package br.com.ada.adviser.web.controller;

import br.com.ada.adviser.domain.service.UserService;
import br.com.ada.adviser.web.dto.request.UserRequest;
import br.com.ada.adviser.web.dto.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Flux<UserResponse>> getAll() {
        final Flux<UserResponse> users = service.getAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public Mono<ResponseEntity<UserResponse>> create(@RequestBody UserRequest request) {
        final Mono<UserResponse> createdUser = service.create(request);
        return createdUser.map(
                user -> ResponseEntity.created(URI.create("/users/" + user.getId())).body(user)
        );
    }

}
