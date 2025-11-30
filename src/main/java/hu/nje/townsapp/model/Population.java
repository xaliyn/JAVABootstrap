package hu.nje.townsapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "populations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "townid")
    private Long townId;

    private Integer ryear;
    private Integer women;
    private Integer total;
}
