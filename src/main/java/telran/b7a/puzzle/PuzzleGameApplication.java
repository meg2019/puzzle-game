package telran.b7a.puzzle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PuzzleGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PuzzleGameApplication.class, args);
	}

}
