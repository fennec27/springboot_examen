package ch.hearc.masrad.springboot.examen.dto;

import ch.hearc.masrad.springboot.examen.entity.Phone;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PhoneResponseDto {

    private Long id;
    private String manufacturer;
    private String model;
    private Integer reviewCount;
    private Integer cameraCount;

    public static PhoneResponseDto fromEntity(Phone phone) {
        return new PhoneResponseDto(phone.getId(), phone.getManufacturer(), phone.getModel(),
                phone.getReviews().size(), phone.getCameras().size());
    }

}
