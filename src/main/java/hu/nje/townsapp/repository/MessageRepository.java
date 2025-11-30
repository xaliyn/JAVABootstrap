package hu.nje.townsapp.repository;

import hu.nje.townsapp.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
