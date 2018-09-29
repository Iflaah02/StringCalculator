import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testValidInputOnlySpots() {
		String numbersStr = "1,2,3";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		assertEquals(ans, 6, ans);
	}
	@Test
	public void testValidInputSpotsAndNewLine() {
		String numbersStr = "1\n2,3";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		assertEquals(ans, 6, ans);
	}
	
	@Test
	public void testValidNewLines() {
		String numbersStr = "1\n2\n3";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		assertEquals(ans, 6, ans);
	}
	
	@Test
	public void testInvalidSpotIsWrong() {
		String numbersStr = "1,\n4";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		//goes to StringCalculatorExpection
		assertEquals(ans, 0, ans);
	}
	
	@Test
	public void testInvalidSpotIsWrong2() {
		String numbersStr = "1\n,4";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		//goes to StringCalculatorExpection
		assertEquals(ans, 0, ans);
	}
	
	@Test
	public void testInvalidAlphaLetter() {
		String numbersStr = "1,A";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		//goes to StringCalculatorExpection
		assertEquals(ans, 0, ans);
	}
	
	@Test
	public void testInvalidNegativeNumber() {
		String numbersStr = "1,-4";
		StringCalculator answer = new StringCalculator();
		int ans = answer.add(numbersStr);
		
		//goes to StringCalculatorExpection
		assertEquals(ans, 0, ans);
	}

}
