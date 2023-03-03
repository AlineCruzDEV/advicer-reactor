package br.com.ada.adviser.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Data
@Table("users")
public class UserEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;
}
