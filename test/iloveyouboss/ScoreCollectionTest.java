package iloveyouboss;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {
	ScoreCollection collection;
	@BeforeEach
	void intializeScoreCollection() {
		collection = new ScoreCollection();
	}
	@Test
	void answersArithmeticMeanOfTwoNumbers() {
		collection.add(() -> 5);
		collection.add(() -> 7);
		
		int actualResult  = collection.arithmeticMean();
		assertThat(actualResult, equalTo(6));
	}
	@Test
	void throwsExceptionWhenAddingNull() {
		assertThrows(IllegalArgumentException.class, ()-> collection.add(null));
	}
	@Test
	void answersZeroWhenNoElementsAdded() {
		assertThat(collection.arithmeticMean(), equalTo(0));
	}
}
