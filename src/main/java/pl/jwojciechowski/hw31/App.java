package pl.jwojciechowski.hw31;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class App {
	public static void main(String[] args) {
		System.out.println("HW 3-1!");
		MongoClient client = new MongoClient("localhost", 27017);

		Morphia morphia = new Morphia();
		morphia.map(Student.class);
		Datastore ds = morphia.createDatastore(client, "school");

		for (int i = 0; i < 200; i++) {
			Student student = ds.find(Student.class).field("_id").equal(i).get();
			System.out.println("Student id: " + student.getStudentId());
			System.out.println("Name: " + student.getStudentName());

			List<Score> scores = student.getScores();
			Score scoreToRemove = null;
			for (Score cur : scores) {
				System.out.println(cur.getType() + " - " + cur.getScore());
				if (cur.getType().equals("homework")) {
					if (scoreToRemove == null) {
						scoreToRemove = cur;
					} else if (scoreToRemove.getScore() > cur.getScore()) {
						scoreToRemove = cur;
					}
				}
			}

			scores.remove(scoreToRemove);
			student.setScores(scores);
			ds.save(student);
		}

		client.close();
	}
}
