package telran.b7a.puzzle.dto.exceptions;

public class PuzzleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1617412670629305892L;
		public PuzzleNotFoundException(Integer id) {
			super("Puzzle with id "+ id + " not found");
		}
}
