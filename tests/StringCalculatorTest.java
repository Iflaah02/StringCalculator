import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testStringCalculator_EmptyStringShouldBe0() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("");
		assertEquals("empty string should return 0", sum, 0);
	}
	
	@Test
	public void testStringCalculator_OneNumberShouldReturnItself() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("1");
		assertEquals("should result the same but integer", sum, 1);
	}
	
	@Test
	public void testStringCalculator_addTwoNumbers() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("13");
		assertEquals("string '13' should become 1+3=4", sum, 4);
	}
	
	@Test
	public void testStringCalculator_addTwoNumbersWithDot() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("1,3");
		assertEquals("string '13' should become 1+3=4", sum, 4);
	}
	
	@Test
	public void testStringCalculator_addTwoNumbersSeparatedWithSpace() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("1 3");
		assertEquals("string '13' should become 1+3=4", sum, 4);
	}
	
	@Test
	public void testStringCalculator_handleInvalidInput() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("asdads");
		assertEquals("invalid input should return 0", sum, 0);
	}
	
	@Test
	public void testStringCalculator_handleSpecialCharacters() {
		StringCalculator stringCalculator = new StringCalculator();
		int sum = stringCalculator.add("$¤#?");
		assertEquals("invalid input should return 0", sum, 0);
	}
}
