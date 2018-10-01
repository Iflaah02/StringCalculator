import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testOneNumber() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		// Assert
		assertEquals(1,calculator.add("1"));	
	}
	
	@Test
	public void testTwoNumbers() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		// Assert
		assertEquals(3,calculator.add("1,2"));
		assertEquals(6,calculator.add("4,2"));
		assertEquals(6,calculator.add("4\n2"));

	}
	
	@Test
	public void testManyNumbers2() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		// Assert
		assertEquals(23,calculator.add("4,5,6,8"));	

	}
	
	@Test
	public void testZero() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		// Assert
		assertEquals(0, calculator.add(""));
	}
	@Test
	public void testNewLine() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		assertEquals(6, calculator.add("1\n2,3"));
		assertEquals(22, calculator.add("4,5\n6,7"));
		assertEquals(18, calculator.add("1,8\n9"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testWrongValues() throws StringCalculatorException{
		StringCalculator calculator = new StringCalculator();
		calculator.add("1234");
		calculator.add(",,,,,1");
		calculator.add("1,");
		calculator.add("t");
	}
	@Test (expected = StringCalculatorException.class)
	public void testhNegativeNumbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		
		calculator.add("-3,-4");
	}
}