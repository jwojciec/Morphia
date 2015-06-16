package pl.jwojciechowski.hw31;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Score {
	String type;
	float score;

	public String getType() {
		return type;
	}

	public float getScore() {
		return score;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setScore(float score) {
		this.score = score;
	}
}
