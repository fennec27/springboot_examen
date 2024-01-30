package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.dto.ConsumerCreationDto;
import ch.hearc.masrad.springboot.examen.dto.ConsumerResponseDto;
import ch.hearc.masrad.springboot.examen.entity.Consumer;
import ch.hearc.masrad.springboot.examen.repository.ConsumerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ConsumerService {

    private final ConsumerRepository consumerRepository;

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

}
