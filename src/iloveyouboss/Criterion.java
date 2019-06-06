package iloveyouboss;

enum Weight{
	DONT_CARE(0), MUST_MATCH(100);
	private int value;
	Weight(int value){
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
public class Criterion {
	
	private Answer answer;
	private Weight weight;
	
	public Criterion(Answer answer, Weight weight) {
		this.answer = answer;
		this.weight = weight;
	}

	public Answer getAnswer() {
		return answer;
	}

	public Weight getWeight() {
		return weight;
	}
}
