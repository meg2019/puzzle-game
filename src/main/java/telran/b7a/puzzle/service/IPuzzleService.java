package telran.b7a.puzzle.service;

import telran.b7a.puzzle.dto.AnswerDto;
import telran.b7a.puzzle.dto.NewUserDto;
import telran.b7a.puzzle.dto.PuzzleDto;
import telran.b7a.puzzle.dto.ResultDto;
import telran.b7a.puzzle.dto.UserDto;

public interface IPuzzleService {
	UserDto addPlayer(NewUserDto newUser);

	UserDto findPlayer(Integer id);

	UserDto updatePlayer(Integer id, NewUserDto updateData);

	void deletePlayer(Integer id);

	PuzzleDto createPuzzle(Integer numOfItems);

	PuzzleDto findPuzzle(Integer id);

	PuzzleDto updatePuzzle(Integer id, Integer numOfItems);

	void deletePuzzle(Integer id);

	ResultDto game(Integer puzzleId, AnswerDto game);

}
