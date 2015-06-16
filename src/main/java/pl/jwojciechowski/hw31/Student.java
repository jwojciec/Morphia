package pl.jwojciechowski.hw31;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity(value = "students")
public class Student {
	@Id
	@Property("_id")
	int studentId;
	@Property("name")
	String studentName;
	@Embedded
	List<Score> scores;

	public int getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
}
