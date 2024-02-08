package ch.hearc.masrad.springboot.examen.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;
    private String model;

    @OneToMany(mappedBy="phone")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "phones")
    private List<Camera> cameras = new ArrayList<>();

    public Phone(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

}
