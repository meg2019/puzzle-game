package telran.b7a.puzzle.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3083254927601600753L;
	
		private final String message;
}
