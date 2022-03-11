package telran.b7a.puzzle.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamInput {
	Integer playerId;
	Integer pazzleId;
	Set<Integer> itemsFound;
}
