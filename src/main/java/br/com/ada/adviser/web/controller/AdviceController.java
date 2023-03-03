package br.com.ada.adviser.web.controller;

import br.com.ada.adviser.domain.service.AdviceService;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/advices")
public class AdviceController {

    private AdviceService service;
    public AdviceController(final AdviceService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Flux<AdviceResponse>> getAll() {
        final Flux<AdviceResponse> advices = service.getAll();
        return ResponseEntity.ok(advices);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<AdviceResponse>> getById(@PathVariable("id") Long id) {
        return service.getById(id)
                .map(advice -> new ResponseEntity<>(advice, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Mono<ResponseEntity<AdviceResponse>> create(@RequestBody AdviceRequest request) {
        final Mono<AdviceResponse> createdAdvice = service.create(request);
        return createdAdvice.map(
                advice -> ResponseEntity.created(URI.create("/advices/" + advice.getId())).body(advice)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deleteById(@PathVariable Long id) {
        // TODO
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
