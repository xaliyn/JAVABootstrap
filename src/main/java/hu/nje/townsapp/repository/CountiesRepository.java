package hu.nje.townsapp.repository;

import hu.nje.townsapp.model.County;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountiesRepository extends JpaRepository<County, Long> {
}
