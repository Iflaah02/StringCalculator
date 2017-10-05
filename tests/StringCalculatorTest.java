import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testStringCalculator_takeEmptyStringAsInput() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		int sum = calculator.add("");
		assertEquals(0, sum);
	}

	@Test
	public void testStringCalculator_take1NumbersAsInput() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		int sum = calculator.add("1");
		assertEquals(1, sum);
	}

	@Test
	public void testStringCalculator_take2NumbersAsInput() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		int sum = calculator.add("1,2");
		assertEquals(3, sum);
	}
	
	@Test
	public void testStringCalculator_takeNegativeNumberAsInput_Exception() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		try {
			int sum = calculator.add("1,-2,3");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use positive numbers only as input");

		}
	}
	
	@Test
	public void testStringCalculator_take2NumberAsInput_NewLineAsDelimiter() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		try {
			int sum = calculator.add("1\n2,3");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use positive numbers only as input");

		}
	}
	
	@Test
	public void testStringCalculator_InvalidInput_Delimiters() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		try {
			int sum = calculator.add("1,\n2");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use only 1 delimiter per value");

		}
	}
	
	@Test
	public void testStringCalculator_InvalidInput_3Delimiters() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		try {
			int sum = calculator.add("4\n,,2");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use only 1 delimiter per value");

		}
	}
	
	@Test
	public void testStringCalculator_InvalidInput_Extra_Delimiters() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		try {
			int sum = calculator.add("\n,2");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use only 1 delimiter per value");

		}
	}
	
	@Test
	public void testStringCalculator_takeNegativeNumbersAsInput_Exception() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		try {
			int sum = calculator.add("-1,-2,-3");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			System.out.println("Use positive numbers only as input");
		}
	}

	@Test
	public void testStringCalculator_take3NumbersAsInput_Exception() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		try {
			int sum = calculator.add("1,2,3");
			fail("Expected StringCalculatorException to be thrown");
		} catch (StringCalculatorException e) {
			
			System.out.println("Use a maximum of 3 numbers as input");

		}
	}

}
