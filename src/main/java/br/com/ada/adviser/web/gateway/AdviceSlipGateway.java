package br.com.ada.adviser.web.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import br.com.ada.adviser.web.client.AdviceSlipClient;
import br.com.ada.adviser.web.dto.response.AdviceSlipResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class AdviceSlipGateway {

    @Autowired
    AdviceSlipClient adviceSlipClient;

    @CircuitBreaker(name="getRandomAdvice", fallbackMethod = "getRandomAdviceFallBack")
    public AdviceSlipResponse getRandomAdvice(){
        return adviceSlipClient.getRandomAdvice();
    }

    private AdviceSlipResponse getRandomAdviceFallBack(Throwable e){
        throw new ResponseStatusException(
            HttpStatus.EXPECTATION_FAILED,
            "Nosso conselheiro foi tomar um café e já volta ;)");
    }
    
}
