package br.com.ada.adviser.infra.topics;

import br.com.ada.adviser.web.dto.response.AdviceResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class AdviceTopicPublisher {
    private Sinks.Many<AdviceResponse> advicesSinks;

    public AdviceTopicPublisher(){
        this.advicesSinks = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(AdviceResponse adviceResponse) {
        this.advicesSinks.tryEmitNext(adviceResponse);
    }
    
    public Flux<AdviceResponse> getNewsFlux() {
        return this.advicesSinks.asFlux();
    }

}
