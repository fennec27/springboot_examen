package ch.hearc.masrad.springboot.examen.dto;

import ch.hearc.masrad.springboot.examen.entity.Consumer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConsumerCreationDto {

    private String name;
    private String email;

    public Consumer toEntity() {
        return new Consumer(name, email);
    }

}
