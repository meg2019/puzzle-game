package telran.b7a.puzzle.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Results")
public class ExamResult {
	int id;
	String name;
	Set<Integer> missingItems;
	
}
