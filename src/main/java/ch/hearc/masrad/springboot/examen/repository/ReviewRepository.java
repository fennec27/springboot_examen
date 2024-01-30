package ch.hearc.masrad.springboot.examen.repository;

import ch.hearc.masrad.springboot.examen.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
