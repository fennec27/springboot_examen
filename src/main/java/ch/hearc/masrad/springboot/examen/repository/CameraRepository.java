package ch.hearc.masrad.springboot.examen.repository;

import ch.hearc.masrad.springboot.examen.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Review, Long> {

    @Query("select count(review) from Review review where review.phone.manufacturer = :manufacturer")
    Integer getCountByPhoneManufacturer(@Param("manufacturer") String manufacturer);

}
