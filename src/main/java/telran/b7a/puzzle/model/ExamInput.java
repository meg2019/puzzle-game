package telran.b7a.puzzle.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ExamInput implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3052411534779031477L;
	@Id
	int id;
	int playerId;
	int pazzleId;
	int[] itemsFound;
}
