package br.com.ada.adviser.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ada.adviser.web.dto.response.AdviceSlipResponse;

@FeignClient(name = "adviceSlip", url = "https://api.adviceslip.com")
public interface AdviceSlipClient {
	
	@RequestMapping(method = RequestMethod.GET, path = "/advice")
	AdviceSlipResponse getRandomAdvice();

}
