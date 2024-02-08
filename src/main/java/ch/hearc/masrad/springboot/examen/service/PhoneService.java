package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.dto.PhoneResponseDto;
import ch.hearc.masrad.springboot.examen.dto.PhoneUpdateDto;
import ch.hearc.masrad.springboot.examen.entity.Phone;
import ch.hearc.masrad.springboot.examen.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public Optional<PhoneResponseDto> getOne(Long id) {
        return phoneRepository.findById(id).map(PhoneResponseDto::fromEntity);
    }

    public List<PhoneResponseDto> getAll() {
        return phoneRepository.findAll().stream().map(PhoneResponseDto::fromEntity).toList();
    }

    public Optional<PhoneResponseDto> update(PhoneUpdateDto dto, Long id) {
        Optional<Phone> phoneOptional = phoneRepository.findById(id);

        if(phoneOptional.isEmpty()) {
            return Optional.empty();
        }

        if (StringUtils.hasLength(dto.getManufacturer())) {
            phoneOptional.get().setManufacturer(dto.getManufacturer());
        }
        if (StringUtils.hasLength(dto.getModel())) {
            phoneOptional.get().setModel(dto.getModel());
        }

        return Optional.of(PhoneResponseDto.fromEntity(phoneRepository.save(phoneOptional.get())));

    }

}
