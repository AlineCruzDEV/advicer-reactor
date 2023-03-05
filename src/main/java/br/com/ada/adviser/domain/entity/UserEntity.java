package br.com.ada.adviser.domain.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@Table("users")
public class UserEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

//    @OneToMany(mappedBy = "user")
//    private List<FavoriteTopicEntity> topics;
}
