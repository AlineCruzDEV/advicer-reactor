package br.com.ada.adviser.domain.repository;

import br.com.ada.adviser.domain.entity.AdviceEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends ReactiveCrudRepository<AdviceEntity, Long> {
}
