package telran.b7a.puzzle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import telran.b7a.puzzle.model.ExamResult;

public interface ExamGameJpaRepository extends JpaRepository<ExamResult, Integer> {

}
