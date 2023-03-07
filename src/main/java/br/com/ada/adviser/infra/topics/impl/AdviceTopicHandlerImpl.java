package br.com.ada.adviser.infra.topics.impl;

import br.com.ada.adviser.domain.repository.TopicRepository;
import br.com.ada.adviser.domain.service.TopicService;
import br.com.ada.adviser.infra.topics.AdviceTopicHandler;
import br.com.ada.adviser.infra.topics.AdviceTopicPublisher;
import br.com.ada.adviser.infra.topics.email.SendEmail;
import br.com.ada.adviser.web.dto.response.AdviceResponse;
import br.com.ada.adviser.web.dto.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AdviceTopicHandlerImpl implements AdviceTopicHandler {

    @Autowired
    private AdviceTopicPublisher adviceTopicPublisher;

    @Autowired
    private SendEmail sendEmail;

    @Autowired
    private TopicService topicService;

    public AdviceTopicHandlerImpl(AdviceTopicPublisher advicePublisher) {
        advicePublisher.getNewsFlux().subscribeOn(Schedulers.newSingle("New thread")).subscribe(
            advice -> {
                //try {
                    final List<String> words = this.splitAdvicesInWords(advice);
                    Flux<UserResponse> userIds = topicService.findUserIdsByTopic(words);
                    userIds.log().subscribe(System.out::println);
                    userIds.subscribe(
                            userResponse -> {
                                sendEmail.send(advice, userResponse);
                            }
                    );
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            },
            error -> log.error("Error " + error)
        );
    }

    @Override
    public void sendNotification(AdviceResponse adviceResponse) {
        adviceTopicPublisher.publish(adviceResponse);
    }

    private List<String> splitAdvicesInWords(final AdviceResponse adviceResponse) {
        final List<String> words = Arrays.asList(
                adviceResponse.getAdvice()
                        .trim()
                        .replace(".", "")
                        .replace(",", "")
                        .split(" "))
                .stream().filter(w -> w.length() > 2)
                .collect(Collectors.toList());
        words.forEach(w -> log.info(w));
        return words;
    }

}
