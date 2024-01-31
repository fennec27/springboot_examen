package ch.hearc.masrad.springboot.examen.controller;

import ch.hearc.masrad.springboot.examen.dto.ConsumerCreationDto;
import ch.hearc.masrad.springboot.examen.dto.ConsumerResponseDto;
import ch.hearc.masrad.springboot.examen.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consumer")
@RequiredArgsConstructor
public class ConsumerController {

    private final ConsumerService consumerService;

    @PostMapping(value = "", consumes =  "application/json", produces = "application/json")
    public ConsumerResponseDto create(@RequestBody ConsumerCreationDto consumer) {
        return consumerService.create(consumer);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public ConsumerResponseDto getOne(@PathVariable Long id) {
        Optional<ConsumerResponseDto> consumer = consumerService.getOne(id);

        if(consumer.isPresent()) {
            return consumer.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consumer not found");
        }
    }

    @GetMapping(value = "", produces = "application/json")
    public List<ConsumerResponseDto> getAll() {
        return consumerService.getAll();
    }

}
