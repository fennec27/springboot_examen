package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.dto.ReviewCreationDto;
import ch.hearc.masrad.springboot.examen.dto.ReviewResponseDto;
import ch.hearc.masrad.springboot.examen.entity.Consumer;
import ch.hearc.masrad.springboot.examen.entity.Phone;
import ch.hearc.masrad.springboot.examen.entity.Review;
import ch.hearc.masrad.springboot.examen.repository.ConsumerRepository;
import ch.hearc.masrad.springboot.examen.repository.PhoneRepository;
import ch.hearc.masrad.springboot.examen.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ConsumerRepository consumerRepository;
    private final PhoneRepository phoneRepository;
    private final ReviewRepository reviewRepository;

    public Optional<ReviewResponseDto> create(ReviewCreationDto dto) {
        Optional<Consumer> consumer = consumerRepository.findById(dto.getConsumerId());

        if(consumer.isEmpty()) {
            return Optional.empty();
        }

        Optional<Phone> phone = phoneRepository.findById(dto.getPhoneId());

        if(phone.isEmpty()) {
            return Optional.empty();
        }

        Review review = dto.toEntity(consumer.get(), phone.get());
        reviewRepository.save(review);

        return Optional.of(ReviewResponseDto.fromEntity(review));
    }

}
