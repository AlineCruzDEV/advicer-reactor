package br.com.ada.advicer.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.management.monitor.MonitorNotification;

@RestController
@RequestMapping("health-check")
public class HelthCheckController {

    @GetMapping
    public Mono<ResponseEntity<String>> healthCheck() {
        return Mono.just(ResponseEntity.ok("Application running! ;)"));
    }
}
