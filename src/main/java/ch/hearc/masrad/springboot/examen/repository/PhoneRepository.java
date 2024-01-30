package ch.hearc.masrad.springboot.examen.repository;

import ch.hearc.masrad.springboot.examen.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
