package br.com.ada.adviser.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("advices")
public class AdviceEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column("id")
    private Long id;

    @Column("advice")
    private String advice;
}
