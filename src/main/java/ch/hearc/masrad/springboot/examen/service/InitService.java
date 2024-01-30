package ch.hearc.masrad.springboot.examen.service;

import ch.hearc.masrad.springboot.examen.entity.Phone;
import ch.hearc.masrad.springboot.examen.repository.ConsumerRepository;
import ch.hearc.masrad.springboot.examen.repository.PhoneRepository;
import ch.hearc.masrad.springboot.examen.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class InitService {

    private final ConsumerRepository consumerRepository;
    private final PhoneRepository phoneRepository;
    private final ReviewRepository reviewRepository;

    public void init() {
        clearTables();
        seedTables();
    }

    private void clearTables() {
        reviewRepository.deleteAll();
        consumerRepository.deleteAll();
        phoneRepository.deleteAll();
    }

    private void seedTables() {
        phoneRepository.save(new Phone("Apple", "iPhone 5"));
        phoneRepository.save(new Phone("Apple", "iPhone 6"));
        phoneRepository.save(new Phone("Huawei", "P20"));
        phoneRepository.save(new Phone("Motorola", "C139"));
        phoneRepository.save(new Phone("Nokia", "105 Series"));
        phoneRepository.save(new Phone("Nokia", "1100"));
        phoneRepository.save(new Phone("Nokia", "1280"));
        phoneRepository.save(new Phone("Samsung ", "Galaxy S4"));
        phoneRepository.save(new Phone("Samsung", "Galaxy S8"));
        phoneRepository.save(new Phone("Xiaomi", "Redmi Note 8"));
    }

}
