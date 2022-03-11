package telran.b7a.puzzle.service;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.b7a.puzzle.dao.ExamGameMongoRepository;
import telran.b7a.puzzle.dao.PlayerMongoRepository;
import telran.b7a.puzzle.dao.PuzzleMongoRepository;
import telran.b7a.puzzle.dto.AnswerDto;
import telran.b7a.puzzle.dto.NewUserDto;
import telran.b7a.puzzle.dto.PuzzleDto;
import telran.b7a.puzzle.dto.ResultDto;
import telran.b7a.puzzle.dto.UserDto;
import telran.b7a.puzzle.dto.exceptions.PlayerNotFoundException;
import telran.b7a.puzzle.dto.exceptions.PuzzleNotFoundException;
import telran.b7a.puzzle.model.ExamResult;
import telran.b7a.puzzle.model.Player;
import telran.b7a.puzzle.model.Puzzel;

@Service
public class PuzzleService implements IPuzzleService {
	PlayerMongoRepository playerRepository;
	PuzzleMongoRepository puzzleRepository;
	ExamGameMongoRepository examGameRepository;
	ModelMapper modelMapper;
	
	
	@Autowired
	public PuzzleService(PlayerMongoRepository playerRepository, PuzzleMongoRepository puzzleRepository,
			ExamGameMongoRepository examGameRepository, ModelMapper modelMapper) {
		this.playerRepository = playerRepository;
		this.puzzleRepository = puzzleRepository;
		this.examGameRepository = examGameRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto addPlayer(NewUserDto newUser) {
		Player player = modelMapper.map(newUser, Player.class);
		playerRepository.save(player);
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	public UserDto findPlayer(Integer id) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	public UserDto updatePlayer(Integer id, NewUserDto updateData) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
		player.setName(updateData.getName());
		player.setBirthDate(updateData.getBirthDate());
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	public void deletePlayer(Integer id) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
		playerRepository.delete(player);
	}

	@Override
	public PuzzleDto createPuzzle(Integer numOfItems) {
		Puzzel puzzle = new Puzzel();
		puzzle.setNumOfItems(numOfItems);
		puzzleRepository.save(puzzle);
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	public PuzzleDto findPuzzle(Integer id) {
		Puzzel puzzle = puzzleRepository.findById(id).orElseThrow(() -> new PuzzleNotFoundException(id));
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	public PuzzleDto updatePuzzle(Integer id, Integer numOfItems) {
		Puzzel puzzle = puzzleRepository.findById(id).orElseThrow(() -> new PuzzleNotFoundException(id));
		puzzle.setNumOfItems(numOfItems);
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	public void deletePuzzle(Integer id) {
		Puzzel puzzle = puzzleRepository.findById(id).orElseThrow(() -> new PuzzleNotFoundException(id));
		puzzleRepository.delete(puzzle);
	}

	@Override
	public ResultDto game(Integer puzzleId, AnswerDto game) {
		Puzzel sessionPuzzle = puzzleRepository.findById(puzzleId).orElseThrow(() -> new PuzzleNotFoundException(puzzleId));
		Player sessionPlayer = playerRepository.findById(game.getPlayerId()).orElseThrow(() -> new PlayerNotFoundException(game.getPlayerId()));
		Integer numOfItems = sessionPuzzle.getNumOfItems();
		Set<Integer> puzzle = new HashSet<>();
		for (int i = 0; i < numOfItems; i++) {
			puzzle.add(i);
		}
		puzzle.removeAll(game.getItemsFound());
		ExamResult result = new ExamResult();
		result.setName(sessionPlayer.getName());
		result.setMissingItems(puzzle);
		examGameRepository.save(result);
		return modelMapper.map(result, ResultDto.class);
	}

}
