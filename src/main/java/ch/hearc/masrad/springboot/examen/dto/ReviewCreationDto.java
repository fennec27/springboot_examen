package ch.hearc.masrad.springboot.examen.dto;

import ch.hearc.masrad.springboot.examen.entity.Consumer;
import ch.hearc.masrad.springboot.examen.entity.Phone;
import ch.hearc.masrad.springboot.examen.entity.Review;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreationDto {

    private String comment;
    private Integer rating;
    private Long consumerId;
    private Long phoneId;

    public Review toEntity(Consumer consumer, Phone phone) {
        return new Review(comment, rating, consumer, phone);
    }

}
