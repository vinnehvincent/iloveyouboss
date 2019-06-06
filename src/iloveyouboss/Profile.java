package iloveyouboss;

import java.util.*;

public class Profile {
	private Map<String, Answer> answers = new HashMap<>();
	private int score;
	private String name;
	
	public Profile(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}

	public String getName() {
		return name;
	}

	public void add(Answer answer) {
		answers.put(answer.getQuestionText(),answer);
	}
	public boolean matches(Criteria criteria) {
		score = 0;
		boolean kill = false;
		boolean anyMatches = false;
		
		for(Criterion criterion: criteria) {
			Answer answer  = answers.get(criterion.getAnswer().getQuestionText());
			boolean match = criterion.getWeight() == Weight.DONT_CARE || answer.match(criterion.getAnswer());
			
			if(!match && criterion.getWeight() == Weight.MUST_MATCH) {
				kill = true;
			}
			if(match) {
				score += criterion.getWeight().getValue();
			}
			anyMatches |= match;
		}
		if(kill)
			return false;
		
		return anyMatches;
	}
	
}