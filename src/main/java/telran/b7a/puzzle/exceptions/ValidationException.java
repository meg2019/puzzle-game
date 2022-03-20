package telran.b7a.puzzle.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7350416450097701212L;
	
		private final String message;
}
