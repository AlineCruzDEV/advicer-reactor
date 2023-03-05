package br.com.ada.adviser.domain.repository;

import br.com.ada.adviser.domain.entity.TopicEntity;
import br.com.ada.adviser.domain.entity.UserEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserEntity, Long> {
    @Query(value = "SELECT * " +
            "FROM TOPICS t " +
            "WHERE t.user_id = :id ")
    Flux<TopicEntity> getTopics(@Param("id") Long id);
}
