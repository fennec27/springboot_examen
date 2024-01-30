package ch.hearc.masrad.springboot.examen.repository;

import ch.hearc.masrad.springboot.examen.entity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}
