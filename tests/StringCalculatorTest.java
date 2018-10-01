import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test1Empty() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		int result = calc.emptyString("");
		// Assert
		assertEquals("Not a empty string", 0, result);
	}
	@Test
	public void test2OneChar() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		int result = calc.oneString("2");
		// Assert
		assertEquals("Empty or more than one char", 2, result);
		
	}
	
	@Test
	public void test3() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.numberOne("12");
		// Assert
		assertEquals("Empty or not a number", 12, result);
	}

	@Test
	public void test4() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.twoNumbers("12,12");
		// Assert
		assertEquals("two numbers miscalculated", 24, result);
	}
	
	
	@Test
	public void test5() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.numbers("12\n12,12,12,12\n12");
		// Assert
		assertEquals("calculation error with 6 numbers incl \n ", 72, result);
	}

	@Test
	public void test6() throws StringCalculatorException {
	StringCalculator calc = new StringCalculator();

	int result = calc.numbers("8,\n");
	// Assert
	assertEquals("Sign for invalid input (-1) expected", -1, result);
	}
	
	@Test
	public void test7() throws StringCalculatorException {
	StringCalculator calc = new StringCalculator();

	int result = calc.numbers("8,5\n");
	// Assert
	assertEquals("Counting 2 digits incl N", 13, result);
	}
	
}
