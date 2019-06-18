package iloveyouboss;

public class BooleanAnswer {
	int id;
	boolean value;
	public BooleanAnswer(int id, boolean value) {
		this.id = id;
		this.value = value;
	}

	public int getQuestionId() {
		return id;
	}

	public boolean getValue() {
		return value;
	}

}
