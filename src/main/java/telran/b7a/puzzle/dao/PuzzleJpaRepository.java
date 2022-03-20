package telran.b7a.puzzle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.b7a.puzzle.model.Puzzel;

public interface PuzzleJpaRepository extends JpaRepository<Puzzel, Integer> {

}
