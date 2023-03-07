package br.com.ada.adviser.infra.topics.email;

import br.com.ada.adviser.web.dto.response.AdviceResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendEmail {

    public void send(AdviceResponse adviceResponse, UserResponse userResponse)  {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("Sending advice \"{}\" to {} at e-mail {}.",
                adviceResponse.getAdvice(), userResponse.getName(), userResponse.getEmail());
    }
}
