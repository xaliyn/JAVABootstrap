package hu.nje.townsapp.repository;

import hu.nje.townsapp.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PopulationsRepository extends JpaRepository<Population, Long> {
    List<Population> findByTownId(Long townId);
}
