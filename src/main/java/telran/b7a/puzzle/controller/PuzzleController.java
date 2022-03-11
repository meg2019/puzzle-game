package telran.b7a.puzzle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.b7a.puzzle.dto.AnswerDto;
import telran.b7a.puzzle.dto.NewUserDto;
import telran.b7a.puzzle.dto.PuzzleDto;
import telran.b7a.puzzle.dto.ResultDto;
import telran.b7a.puzzle.dto.UserDto;
import telran.b7a.puzzle.service.IPuzzleService;

@RestController
@RequestMapping("/api")
public class PuzzleController {
	IPuzzleService puzzleService;

	@Autowired
	public PuzzleController(IPuzzleService puzzleService) {
		this.puzzleService = puzzleService;
	}
	
	@PostMapping("/puzzle/{puzzleId}")
	public ResultDto checkResult(@RequestBody AnswerDto answer, @PathVariable Integer puzzleId) {
		return puzzleService.game(puzzleId, answer);
		
	}
	
	@PostMapping("/puzzle")
	public PuzzleDto createPuzzle(@RequestParam Integer numOfItems) {
		return puzzleService.createPuzzle(numOfItems);
		
	}
	
	@PostMapping("/player")
	public UserDto addPlayer(@RequestBody NewUserDto newUser) {
		return puzzleService.addPlayer(newUser);
		
	}
}
