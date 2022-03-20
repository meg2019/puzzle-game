package telran.b7a.puzzle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.b7a.puzzle.model.Player;

public interface PlayerJpaRepository extends JpaRepository<Player, Integer> {

}
