package br.com.ada.adviser.domain.repository;

import br.com.ada.adviser.domain.entity.TopicEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends ReactiveCrudRepository<TopicEntity, Long> {
}
