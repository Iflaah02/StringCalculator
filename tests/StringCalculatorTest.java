import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
    
	//Tests for the first condition
	@Test
	public void testAdd_NoNumbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();

		assertEquals("Does not return 0", 0, calc.add(""));

	}
	
	@Test
	public void testAdd_OneNumber() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		assertEquals("Does not return 5", 5, calc.add("5"));

	}
	
	@Test
	public void testAdd_TwoNumbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();

		assertEquals("Does not return 8", 8, calc.add("5,3"));

	}
	
	//Test for the second condition
	@Test
	public void testAdd_FiveNumbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();

		assertEquals("Should return 15", 15, calc.add("1,2,3,4,5"));

	}
	
	//Tests for third condition
	@Test
	public void testAdd_NewLine() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();

		assertEquals("Does not accept new lines", 15, calc.add("1,2\n3,4\n5"));

	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAdd_Comma_And_NewLine() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		calc.add("1,\n2");
	}
	
	//Tests for the fourth condition
	@Test (expected = StringCalculatorException.class)
	public void testAdd_GarbageInput() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,2\n3djawuiodhawdaw");
		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAdd_NegativeNumbers() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,-2,5,-3");
	}
}
