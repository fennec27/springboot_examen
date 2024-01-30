package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.dto.PhoneResponseDto;
import ch.hearc.masrad.springboot.examen.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public Optional<PhoneResponseDto> getOne(Long id) {
        return phoneRepository.findById(id).map(PhoneResponseDto::fromEntity);
    }

    public List<PhoneResponseDto> getAll() {
        return phoneRepository.findAll().stream().map(PhoneResponseDto::fromEntity).toList();
    }

}
