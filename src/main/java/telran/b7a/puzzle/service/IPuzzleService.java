package telran.b7a.puzzle.service;

import telran.b7a.puzzle.dto.AnswerDto;
import telran.b7a.puzzle.dto.NewUserDto;
import telran.b7a.puzzle.dto.PuzzleDto;
import telran.b7a.puzzle.dto.ResultDto;
import telran.b7a.puzzle.dto.UserDto;
import telran.b7a.puzzle.exceptions.NotFoundException;

public interface IPuzzleService {
	UserDto addPlayer(NewUserDto newUser);

	UserDto findPlayer(Integer id) throws NotFoundException;

	UserDto updatePlayer(Integer id, NewUserDto updateData) throws NotFoundException;

	void deletePlayer(Integer id) throws NotFoundException;

	PuzzleDto createPuzzle(Integer numOfItems);

	PuzzleDto findPuzzle(Integer id) throws NotFoundException;

	PuzzleDto updatePuzzle(Integer id, Integer numOfItems) throws NotFoundException;

	void deletePuzzle(Integer id) throws NotFoundException;

	ResultDto game(Integer puzzleId, AnswerDto game) throws NotFoundException;

}
