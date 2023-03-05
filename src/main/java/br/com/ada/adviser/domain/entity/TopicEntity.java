package br.com.ada.adviser.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("topics")
public class TopicEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

//    @JoinColumn(name = "user_id", nullable = false)
//    @ManyToOne(fetch = FetchType.EAGER)
//    private UserEntity user;
    @Column("user_id")
    private Long userId;
}
