import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	//comment
	@Test
	public void testStringEmpty() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "";
		
		assertEquals(false , calculator.checkLength(numbersStr));
	}
	
	@Test
	public void testStringTooLong() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1,2,3";
		
		assertEquals(false , calculator.checkLength(numbersStr));
	}
	
	@Test
	public void testStringLength() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "11,22";
		
		assertEquals(true , calculator.checkLength(numbersStr));
	}
	
	@Test
	public void testSumComma() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1,2";
		
		assertEquals(3 , calculator.add(numbersStr));
	}
	
	@Test
	public void testSumNewLine() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "1\n2";
		
		assertEquals(3 , calculator.add(numbersStr));
	}

	@Test
	public void testLetters() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "abc";
		
		assertEquals(false , calculator.checkInput(numbersStr));
	}
	
	@Test
	public void testLetters2() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "n12";
		
		assertEquals(false , calculator.checkInput(numbersStr));
	}
	
	@Test
	public void testSumEmpty() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "";
		
		assertEquals(0 , calculator.add(numbersStr));
	}
	
	@Test
	public void testSum() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "11,22";
		
		assertEquals(33 , calculator.add(numbersStr));
	}
	
	@Test
	public void testOneNumber() {
		
		StringCalculator calculator = new StringCalculator();
		String numbersStr = "10";
		
		assertEquals(10 , calculator.add(numbersStr));
	}
}
