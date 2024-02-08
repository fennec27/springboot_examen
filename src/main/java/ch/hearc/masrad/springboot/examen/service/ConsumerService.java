package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.dto.ConsumerCreationDto;
import ch.hearc.masrad.springboot.examen.dto.ConsumerResponseDto;
import ch.hearc.masrad.springboot.examen.entity.Consumer;
import ch.hearc.masrad.springboot.examen.entity.Review;
import ch.hearc.masrad.springboot.examen.repository.ConsumerRepository;
import ch.hearc.masrad.springboot.examen.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ConsumerService {

    private final ConsumerRepository consumerRepository;
    private final ReviewRepository reviewRepository;

    public ConsumerResponseDto create(ConsumerCreationDto dto) {
        Consumer consumer = dto.toEntity();
        consumerRepository.save(consumer);

        return ConsumerResponseDto.fromEntity(consumer);
    }

    public Optional<ConsumerResponseDto> getOne(Long id) {
        return consumerRepository.findById(id).map(ConsumerResponseDto::fromEntity);
    }

    public List<ConsumerResponseDto> getAll() {
        return consumerRepository.findAll().stream().map(ConsumerResponseDto::fromEntity).toList();
    }

    public boolean DeleteAllReview(Long id){
        Optional<Consumer> op = consumerRepository.findById(id);
        if (op.isEmpty()) return false;

        reviewRepository.deleteAll(op.get().getReviews());

        return true;
    }


}
