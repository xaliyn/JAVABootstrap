package hu.nje.townsapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "towns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tname;

    @Column(name = "countyid")
    private Long countyid;

    private String countyseat;

    private String countylevel;
}
