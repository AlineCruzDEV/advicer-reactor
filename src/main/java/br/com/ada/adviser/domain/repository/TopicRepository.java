package br.com.ada.adviser.domain.repository;

import br.com.ada.adviser.domain.entity.TopicEntity;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TopicRepository extends ReactiveCrudRepository<TopicEntity, Long> {
    @Query(value = "SELECT DISTINCT t.user_id " +
            "FROM TOPICS t " +
            "WHERE UPPER(t.name) = UPPER(:name) ")
    Flux<Long> findUserIdsByTopic(@Param("name") String name);

    @Query(value = "SELECT DISTINCT t.user_id " +
            "FROM TOPICS t " +
            "WHERE UPPER(t.name) IN (:names)")
    Flux<Long> findUserIdsByTopics(@Param("names") List<String> names);
}
