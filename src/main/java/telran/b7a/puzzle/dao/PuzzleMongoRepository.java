package telran.b7a.puzzle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.b7a.puzzle.model.Puzzel;

public interface PuzzleMongoRepository extends MongoRepository<Puzzel, Integer> {

}
