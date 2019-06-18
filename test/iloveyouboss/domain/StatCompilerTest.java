package iloveyouboss.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import iloveyouboss.BooleanAnswer;

public class StatCompilerTest {
	
	@Test
	public void responsesByQuestionAnswersCountsByText() {
		
		StatCompiler stats = new StatCompiler();
		List<BooleanAnswer> answers = new ArrayList<>();
		
		answers.add(new BooleanAnswer(1, true));
		answers.add(new BooleanAnswer(1, true));
		answers.add(new BooleanAnswer(1, true));
		answers.add(new BooleanAnswer(1, false));
		answers.add(new BooleanAnswer(2, true));
		answers.add(new BooleanAnswer(2, true));
		
		Map<Integer, String> questions = new HashMap<>();
		questions.put(1, "Tuition reimbursement?");
		questions.put(2, "Relocation package?");
		
		Map<String,Map<Boolean, AtomicInteger>> responses = stats.reponsesByQuestion(answers, questions);
		
		assertThat(responses.get("Tuition reimbursement?").get(Boolean.TRUE).get(), equalTo(3));
		assertThat(responses.get("Tuition reimbursement?").get(Boolean.FALSE).get(), equalTo(1));
		assertThat(responses.get("Relocation package?").get(Boolean.TRUE).get(), equalTo(2));
	}
}
