package br.com.ada.adviser.infra.topics.email;

import br.com.ada.adviser.web.dto.response.AdviceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEmail {

    public void send(AdviceResponse adviceResponse) throws InterruptedException {
        //Thread.sleep(8000);
        log.info("Sending email to xxx");// + salesResponse.getClientName());
    }
}
