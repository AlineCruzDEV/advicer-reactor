package br.com.ada.adviser.infra.topics;

import br.com.ada.adviser.web.dto.response.AdviceResponse;

public interface AdviceTopicHandler {
    void sendTopic(AdviceResponse adviceResponse);
}
