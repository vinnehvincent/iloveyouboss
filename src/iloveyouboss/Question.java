package iloveyouboss;

public abstract class Question{
	int id;
	String text;
	String[] answerChoices;
	public Question(int id, String text, String[] answerChoices) {
		this.id = id;
		this.text = text;
		this.answerChoices = answerChoices;
	}
	public int getQuestionId() {
		return id;
	}
	public void setQuestionId(int id) {
		this.id = id;
	}
	public String getQuestionText() {
		return text;
	}
	public void setQuestionText(String text) {
		this.text = text;
	}
	public abstract boolean match(int expected, int actual);
	
}