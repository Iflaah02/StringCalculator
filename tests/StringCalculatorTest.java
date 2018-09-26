import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testEmpty() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		int result = calc.emptyString("");
		// Assert
		assertEquals("No empty string", 0, result);
	}
	@Test
	public void testOneChar() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		int result = calc.oneString("2");
		// Assert
		assertEquals("No empty string", 2, result);
		
	}
	@Test
	public void test2() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.numberOne("12");
		// Assert
		assertEquals("No empty string", 12, result);
	}

	@Test
	public void test3() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.twoNumbers("12,12");
		// Assert
		assertEquals("No empty string", 24, result);
	}
	@Test
	public void test31() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.twoNumbers("12,");
		// Assert
		assertEquals("No empty string", 12, result);
	}
	@Test
	public void test4() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.twoNumbersWithN("12\n12");
		// Assert
		assertEquals("No empty string", 24, result);
	}
	@Test
	public void test5() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
	
		int result = calc.numbers("12\n12,12,12,12\n12");
		// Assert
		assertEquals("No empty string", 72, result);
	}

	@Test
	public void test6() throws StringCalculatorException {
	StringCalculator calc = new StringCalculator();

	int result = calc.numbers("8,\n");
	// Assert
	assertEquals("No empty string", -1, result);
	}
	@Test
	public void test7() throws StringCalculatorException {
	StringCalculator calc = new StringCalculator();

	int result = calc.numbers("8,5\n");
	// Assert
	assertEquals("No empty string", 13, result);
	}
}
