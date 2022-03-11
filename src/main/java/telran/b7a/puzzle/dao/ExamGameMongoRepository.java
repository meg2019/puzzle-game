package telran.b7a.puzzle.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import telran.b7a.puzzle.model.ExamResult;

public interface ExamGameMongoRepository extends MongoRepository<ExamResult, Integer> {

}
