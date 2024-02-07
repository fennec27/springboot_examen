package ch.hearc.masrad.springboot.examen.controller;

import ch.hearc.masrad.springboot.examen.dto.PhoneResponseDto;
import ch.hearc.masrad.springboot.examen.dto.PhoneUpdateDto;
import ch.hearc.masrad.springboot.examen.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("phone")
@RequiredArgsConstructor
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

    @PutMapping(value = "{id}", consumes =  "application/json", produces = "application/json")
    public PhoneResponseDto update(@RequestBody PhoneUpdateDto dto, @PathVariable Long id) {
        Optional<PhoneResponseDto> phone = phoneService.update(dto, id);

        if(phone.isPresent()) {
            return phone.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Phone not found");
        }
    }

}
