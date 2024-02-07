package ch.hearc.masrad.springboot.examen.dto;

import ch.hearc.masrad.springboot.examen.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneUpdateDto {

    private String manufacturer;
    private String model;

    public PhoneUpdateDto toEntity(Phone phone) {
        return new PhoneUpdateDto(phone.getManufacturer(), phone.getModel());
    }

}
