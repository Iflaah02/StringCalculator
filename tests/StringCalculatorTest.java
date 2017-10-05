import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void sumOneNumberTest() {
		StringCalculator calculator = new StringCalculator();
		int expectedOutput = 2;

		int value = calculator.add("2");
		assertEquals(expectedOutput, value);
	}

	@Test
	public void passTestIfEmptyStringTest() {
		StringCalculator calculator = new StringCalculator();

		int expectedOutput = 0;
		int value = calculator.add(" ");

		assertEquals(value, expectedOutput);
	}

	@Test
	public void SumTwoNumbersTest() {
		StringCalculator calculator = new StringCalculator();

		int expectedOutput = 10;
		int value = calculator.add("4, 6");

		assertEquals(expectedOutput, value);
	}

	@Test
	public void DontAcceptMoreThanTwoNumbersTest() {
		StringCalculator calculator = new StringCalculator();

		int expectedOutput = 15;
		int value = calculator.add("2, 10, 3");
		
		assertNotEquals(value, expectedOutput);

	}
	
	@Test
	public void DontAcceptNegativeNumbersTest(){
		StringCalculator calculator = new StringCalculator();
		
		int expectedOutput = -5;
		int value = calculator.add("-2, -3");
		
		assertNotEquals(value, expectedOutput);
		
	}
	

}
