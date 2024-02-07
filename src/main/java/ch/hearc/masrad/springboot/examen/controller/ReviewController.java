package ch.hearc.masrad.springboot.examen.controller;

import ch.hearc.masrad.springboot.examen.dto.ReviewCreationDto;
import ch.hearc.masrad.springboot.examen.dto.ReviewResponseDto;
import ch.hearc.masrad.springboot.examen.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(value = "", consumes =  "application/json", produces = "application/json")
    public ReviewResponseDto create(@RequestBody ReviewCreationDto dto) {
        Optional<ReviewResponseDto> review = reviewService.create(dto);

        if(review.isPresent()) {
            return review.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Consumer or phone not found");
        }
    }

    @GetMapping(value = "", produces = "application/json")
    public Integer getCountForManufacturer(@RequestParam String manufacturer) {
        return reviewService.getCountForManufacturer(manufacturer);
    }

}
