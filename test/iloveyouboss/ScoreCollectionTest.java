package iloveyouboss;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {

	@Test
	void answersArithmeticMeanOfTwoNumbers() {
		//Arrange
		ScoreCollection collection = new ScoreCollection();
		collection.add(() -> 5);
		collection.add(() -> 7);
		
		//Act 
		int actualResult  = collection.arithmeticMean();
		
		//Assert
		assertThat(actualResult, equalTo(6));
	}
	@Test
	void throwsExceptionWhenAddingNull() {
		ScoreCollection collection = new ScoreCollection();
		assertThrows(IllegalArgumentException.class, ()-> collection.add(null));
	}

}
