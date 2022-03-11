package telran.b7a.puzzle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.b7a.puzzle.model.Player;

public interface PlayerMongoRepository extends MongoRepository<Player, Integer> {

}
