package iloveyouboss;

public class BooleanQuestion extends Question {
	
	int allowable;
	
	public BooleanQuestion(int i, String text) {
		super(text);
		this.allowable = i;
	}
}
