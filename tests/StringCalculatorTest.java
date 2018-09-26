import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testStringLength0() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "";
		
		assertEquals(false , calculator.checkLength(numbersStr));
	}
	
	@Test
	public void testStringLength3() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1,2,3";
		
		assertEquals(false , calculator.checkLength(numbersStr));
	}
	
	@Test
	public void testSum() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1,2";
		
		assertEquals(3 , calculator.add(numbersStr));
	}
	
	@Test
	public void testSum3() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1\n2";
		
		assertEquals(3 , calculator.add(numbersStr));
	}

	@Test
	public void testLetters() throws StringCalculatorException{
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "abc";
		
		assertEquals(false , calculator.checkInput(numbersStr));
	}
	
	@Test
	public void testLetters2() throws StringCalculatorException{
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "n12";
		
		assertEquals(false , calculator.checkInput(numbersStr));
	}
}
