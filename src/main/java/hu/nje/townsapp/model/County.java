package hu.nje.townsapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "counties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cname;
}
