package br.com.ada.adviser.domain.repository;

import br.com.ada.adviser.domain.entity.FavoriteTopicEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteTopicRepository extends ReactiveCrudRepository<FavoriteTopicEntity, Long> {
}
