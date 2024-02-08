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
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long resolution;

    @ManyToMany
    @JoinTable( name = "camera_phone",
            joinColumns = @JoinColumn(name = "camera_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "phone_id", referencedColumnName = "id"))
    private List<Camera> cameras = new ArrayList<>();


    public Camera(String name, Long resolution) {
        this.name = name;
        this.resolution = resolution;
    }

}
