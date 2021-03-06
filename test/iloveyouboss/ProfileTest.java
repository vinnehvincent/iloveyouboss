package iloveyouboss;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileTest {
	
	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria;
	
	@BeforeEach
	public void create() {
		profile = new Profile("Bull Hockey, Inc");
		question = new BooleanQuestion(1,"Got Bonuses?");
		criteria = new Criteria();
	}
	@Test
	void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		
		profile.add(new Answer(question, Bool.FALSE));
		Criterion criterion = new Criterion(new Answer(question,Bool.TRUE),Weight.MUST_MATCH);
		criteria.add(criterion);
		
		boolean matches = profile.matches(criteria);
		assertFalse(matches);
		
	}
	@Test
	void matchAnswersTrueForAnyDontCareCriteria() {
		
		profile.add(new Answer(question, Bool.FALSE));
		Criterion criterion = new Criterion(new Answer(question,Bool.TRUE),Weight.DONT_CARE);
		criteria.add(criterion);
		
		boolean matches = profile.matches(criteria);
		assertTrue(matches);
		
	}
	@Test
	void matchAnswersTrueWhenDesiredValuesMatch() {
		Answer answer = new Answer(question, Bool.TRUE);
		
		profile.add(answer);
		Criterion criterion = new Criterion(answer, Weight.MUST_MATCH);
		criteria.add(criterion);
		
		boolean matches = profile.matches(criteria);
		assertTrue(matches);
	}

}
