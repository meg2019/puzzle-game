package telran.b7a.puzzle.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.b7a.puzzle.dao.ExamGameJpaRepository;
import telran.b7a.puzzle.dao.PlayerJpaRepository;
import telran.b7a.puzzle.dao.PuzzleJpaRepository;
import telran.b7a.puzzle.dto.AnswerDto;
import telran.b7a.puzzle.dto.NewUserDto;
import telran.b7a.puzzle.dto.PuzzleDto;
import telran.b7a.puzzle.dto.ResultDto;
import telran.b7a.puzzle.dto.UserDto;
import telran.b7a.puzzle.exceptions.NotFoundException;
import telran.b7a.puzzle.model.ExamResult;
import telran.b7a.puzzle.model.Player;
import telran.b7a.puzzle.model.Puzzel;

@Service
public class PuzzleService implements IPuzzleService {
	PlayerJpaRepository playerRepository;
	PuzzleJpaRepository puzzleRepository;
	ExamGameJpaRepository examGameRepository;
	ModelMapper modelMapper;

	@Autowired
	public PuzzleService(PlayerJpaRepository playerRepository, PuzzleJpaRepository puzzleRepository,
			ExamGameJpaRepository examGameRepository, ModelMapper modelMapper) {
		this.playerRepository = playerRepository;
		this.puzzleRepository = puzzleRepository;
		this.examGameRepository = examGameRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public UserDto addPlayer(NewUserDto newUser) {
		Player player = modelMapper.map(newUser, Player.class);
		playerRepository.save(player);
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	public UserDto findPlayer(Integer id) throws NotFoundException {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	@Transactional
	public UserDto updatePlayer(Integer id, NewUserDto updateData) throws NotFoundException {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
		player.setName(updateData.getName());
		player.setBirthDate(updateData.getBirthDate());
		return modelMapper.map(player, UserDto.class);
	}

	@Override
	@Transactional
	public void deletePlayer(Integer id) throws NotFoundException {
		Player player = playerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " not found"));
		playerRepository.delete(player);
	}

	@Override
	@Transactional
	public PuzzleDto createPuzzle(Integer numOfItems) {

		Puzzel puzzle = new Puzzel();
		puzzle.setNumOfItems(numOfItems);

		puzzleRepository.save(puzzle);
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	public PuzzleDto findPuzzle(Integer id) throws NotFoundException {
		Puzzel puzzle = puzzleRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Puzzle with id " + id + " not found"));
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	@Transactional
	public PuzzleDto updatePuzzle(Integer id, Integer numOfItems) throws NotFoundException {
		Puzzel puzzle = puzzleRepository.findById(id).orElseThrow(() -> new NotFoundException("Puzzle with id " + id + " not found"));
		puzzle.setNumOfItems(numOfItems);
		return modelMapper.map(puzzle, PuzzleDto.class);
	}

	@Override
	@Transactional
	public void deletePuzzle(Integer id) throws NotFoundException {
		Puzzel puzzle = puzzleRepository.findById(id).orElseThrow(() -> new NotFoundException("Puzzle with id " + id + " not found"));
		puzzleRepository.delete(puzzle);
	}

	@Override
	@Transactional
	public ResultDto game(Integer puzzleId, AnswerDto game) throws NotFoundException {

		Puzzel sessionPuzzle = puzzleRepository.findById(puzzleId)
				.orElseThrow(() -> new NotFoundException("Puzzle with id " + puzzleId + " not found"));
		Player sessionPlayer = playerRepository.findById(game.getPlayerId())
				.orElseThrow(() -> new NotFoundException("User with id " + game.getPlayerId() + " not found"));

		Integer numOfItems = sessionPuzzle.getNumOfItems();
		Set<Integer> puzzle = new HashSet<>();
		for (int i = 1; i <= numOfItems; i++) {
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
