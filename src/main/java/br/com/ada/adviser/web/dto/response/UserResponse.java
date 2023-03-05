package br.com.ada.adviser.web.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    //private List<TopicResponse> topics;
}
