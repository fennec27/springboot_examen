package ch.hearc.masrad.springboot.examen.controller;

import ch.hearc.masrad.springboot.examen.dto.PhoneResponseDto;
import ch.hearc.masrad.springboot.examen.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("phone")
@AllArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping(value = "{id}", produces = "application/json")
    public PhoneResponseDto getOne(@PathVariable Long id) {
        Optional<PhoneResponseDto> phone = phoneService.getOne(id);

        if(phone.isPresent()) {
            return phone.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone not found");
        }
    }

    @GetMapping(value = "", produces = "application/json")
    public List<PhoneResponseDto> getAll() {
        return phoneService.getAll();
    }

}
