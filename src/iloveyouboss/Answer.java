package iloveyouboss;
public class Answer {
	private Question question;
	private Bool desiredValue;
	
	public Answer(Question question, Bool desiredValue) {
		this.question = question;
		this.desiredValue = desiredValue;
	}
	public int getQuestionId() {
		return question.id;
	}
	public String getQuestionText() {
		return question.text;
	}

	public boolean match(Answer answer) {
		return answer.getQuestionText().equals(question.text) && answer.desiredValue == desiredValue;
	}

}
