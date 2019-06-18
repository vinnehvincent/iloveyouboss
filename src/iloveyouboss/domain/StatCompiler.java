package iloveyouboss.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import iloveyouboss.BooleanAnswer;
import iloveyouboss.Question;

public class StatCompiler {
	private QuestionController controller = new QuestionController();
	
	public Map<String,Map<Boolean, AtomicInteger>> reponsesByQuestion(final List<BooleanAnswer> answers, Map<Integer,String> questions){
		Map<Integer,Map<Boolean, AtomicInteger>> responses = new HashMap<>();
		answers.stream().forEach(answer -> getHistogram(responses,answer));
		return convertHistogramIdsToText(responses,questions);
		
	}

	private Map<String, Map<Boolean, AtomicInteger>> convertHistogramIdsToText(
			Map<Integer, Map<Boolean, AtomicInteger>> responses, Map<Integer, String> questions) {
		Map<String,Map<Boolean, AtomicInteger>> textResponses = new HashMap<>();
		responses.keySet().stream().forEach(id -> textResponses.put(questions.get(id), responses.get(id)));
		return textResponses;
	}

	private void getHistogram(Map<Integer, Map<Boolean, AtomicInteger>> responses, BooleanAnswer answer) {
		Map<Boolean, AtomicInteger> histogram = getHistogram(responses,answer.getQuestionId());
		histogram.get(Boolean.valueOf(answer.getValue())).getAndIncrement();
		
	}

	private Map<Boolean, AtomicInteger> getHistogram(Map<Integer, Map<Boolean, AtomicInteger>> responses,
			int questionId) {
		Map<Boolean, AtomicInteger> histogram = null;
		if(responses.containsKey(questionId)) {
			histogram = responses.get(questionId);
		}
		else {
			histogram = creatNewHistogram();
			responses.put(questionId, histogram);
		}
		return histogram;
	}

	private Map<Boolean, AtomicInteger> creatNewHistogram() {
		Map<Boolean, AtomicInteger> histogram = new HashMap<>();
		histogram.put(Boolean.FALSE, new AtomicInteger(0));
		histogram.put(Boolean.TRUE, new AtomicInteger(0));
		return histogram;
	}
	public Map<Integer,String> questionText(List<BooleanAnswer> answers) {
		Map<Integer,String> questions = new HashMap<>();
		answers.stream().forEach(answer -> {
			if(!questions.containsKey(answer.getQuestionId())) {
				questions.put(answer.getQuestionId(), controller.find(answer.getQuestionId()).getQuestionText());
			}
		});
		return questions;
	}



}
