import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void sumZeroValues() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
				
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 0, sum);
	}
	@Test
	public void sumOneValue() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1");
		
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 1, sum);
	}
	@Test
	public void sumTwoSingleDigitValues() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,2");
		
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 3, sum);
	}
	
	@Test
	public void sumTwoMultipleDigitValues() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("11,22");
		
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 33, sum);
	}

	@Test
	public void testSplitString() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.splitString("");
				
		assertEquals("Invalid splitted string length", 1, calc.getArrString().length);
	}
	
	@Test
	public void sumNewLine() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1\n2");
		
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 3, sum);
	}
	@Test
	public void sumNewLineAndComma() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1\n2,3");
		
		int sum = calc.getSum();
		
		assertEquals("Invalid sum", 6, sum);
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testInvalidString() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,2,asd");
		
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testNegativeNumber() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("-1,3");

	}
	
	@Test(expected = StringCalculatorException.class)
	public void testStringEmptyValueInMiddle() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,3,\n,5");	
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testStringEndWithNewline() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,3,\n5\n");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testStringEndWithComma() throws StringCalculatorException{
		StringCalculator calc = new StringCalculator();
		
		calc.add("1,3,\n5,");
	}
}
