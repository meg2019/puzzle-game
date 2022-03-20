package telran.b7a.puzzle.scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import telran.b7a.puzzle.dao.ExamGameJpaRepository;
import telran.b7a.puzzle.model.ExamResult;

@Component
public class BackUpExamGameJpaRepository {
	ExamGameJpaRepository examGameRepository;
	
	@Autowired
	public BackUpExamGameJpaRepository(ExamGameJpaRepository examGameRepository) {
		this.examGameRepository = examGameRepository;
	}
	
	@Scheduled(cron = "0 */15 * ? * *")
	public void uploadExamGameRepository() throws IOException {
		List<ExamResult> results = examGameRepository.findAll();
		File backup = new File("/home/megazoid/tmp/backUpGR.dat");
		FileOutputStream fileOutputStream = new FileOutputStream(backup);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		try {
			objectOutputStream.writeObject(results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fileOutputStream.close();
		System.out.println("successfull!");
	}
	

}
