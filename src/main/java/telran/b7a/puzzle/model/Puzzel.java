package telran.b7a.puzzle.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Puzzel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5070552345440029389L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int numOfItems;
}
