package br.com.ada.adviser.web.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TopicResponse {
    private Long id;
    private String name;
    private Long userId;
}
