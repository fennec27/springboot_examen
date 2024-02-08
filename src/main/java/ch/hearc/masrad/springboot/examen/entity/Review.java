package ch.hearc.masrad.springboot.examen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="consumer_id")
    @JsonIgnore
    private Consumer consumer;

    @ManyToOne
    @JoinColumn(name="phone_id")
    private Phone phone;

    public Review(String comment, Integer rating, Consumer consumer, Phone phone) {
        this.comment = comment;
        this.rating = rating;
        this.consumer = consumer;
        this.phone = phone;
    }

}
