package br.com.ada.adviser.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ada.adviser.domain.service.AdviceService;
import br.com.ada.adviser.web.client.AdviceSlipClient;
import br.com.ada.adviser.web.dto.request.AdviceRequest;
import br.com.ada.adviser.web.dto.response.AdviceSlipResponse;
import br.com.ada.adviser.web.gateway.AdviceSlipGateway;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AdviseRetriever {
	@Autowired
	private AdviceSlipGateway adviceSlipGateway;
	
	@Autowired
	private AdviceService adviceService;

	@Scheduled(fixedDelay = 1000)
	public void getAdvice() {
		try {
			AdviceSlipResponse response = adviceSlipGateway.getRandomAdvice();
			String advice = response.getSlip().getAdvice();
			adviceService.create(new AdviceRequest(advice)).subscribe(adviceRequest -> {
				log.info("Novo conselho: {}", advice);
			});
		} catch(Exception e) {
			log.error("Erro ao buscar conselho de API externa", e);
		}
	}
}
