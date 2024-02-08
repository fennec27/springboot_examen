package ch.hearc.masrad.springboot.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;
    String email;

    @OneToMany(mappedBy="consumer")
    private List<Review> reviews = new ArrayList<>();

    public Consumer(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
