import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testWith0And2And2NumbersSeparatedWithComma() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		assertEquals(0, calculator.add(""));
		assertEquals(1, calculator.add("1"));
		assertEquals(3, calculator.add("1,2"));
	}
	
	@Test
	public void testWithUnknownAmountOfNumbersSeparatedWithComma() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		assertEquals(12, calculator.add("4,7,1"));
		assertEquals(17, calculator.add("4,7,1,5"));
		assertEquals(23, calculator.add("1,2,3,8,9"));
		
	}
		
	@Test
	public void testWithNewLinesBetweenNumbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		assertEquals(14, calculator.add("3\n5,6"));
		assertEquals(21, calculator.add("3,5\n6,7"));
		assertEquals(24, calculator.add("3,6,7\n8"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testWithNegativeNumbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		//Negative numbers
		calculator.add("-1,-5");
	}

	@Test (expected = StringCalculatorException.class)
	public void testWithInvalidInput1() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
	
		//Invalid input
		calculator.add("1,\n");

	}
	
	@Test (expected = StringCalculatorException.class)
	public void testWithInvalidInput2() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
	
		//Invalid input
		calculator.add(",,,,,1");
	}
}
