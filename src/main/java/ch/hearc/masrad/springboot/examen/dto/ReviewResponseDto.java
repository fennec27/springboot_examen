package ch.hearc.masrad.springboot.examen.dto;

import ch.hearc.masrad.springboot.examen.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewResponseDto {

    private Long id;
    private String comment;
    private Integer rating;
    private Long consumerId;
    private Long phoneId;

    public static ReviewResponseDto fromEntity(Review review) {
        return new ReviewResponseDto(review.getId(), review.getComment(), review.getRating(),
                review.getConsumer().getId(), review.getPhone().getId());
    }

}
