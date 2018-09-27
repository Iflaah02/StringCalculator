import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testVerifyString_ValidTwoNumbers() {
		// Arrange
		StringCalculator calc = new StringCalculator();
		boolean result = false;
		
		// Act
		result = calc.verifyString("1,2");
		
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void testVerifyString_ValidOneNumber() {
		// Arrange
		StringCalculator calc = new StringCalculator();
		boolean result = false;
		
		// Act
		result = calc.verifyString("322");
		
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void testVerifyString_InvalidCharacters() {
		// Arrange
		StringCalculator calc = new StringCalculator();
		boolean result = false;
		
		// Act
		result = calc.verifyString("1k,2");
		
		// Assert
		assertEquals(false, result);
	}
	
//	@Test
//	public void testVerifyString_TooManyNumbers() {
//		// Arrange
//		StringCalculator calc = new StringCalculator();
//		boolean result = false;
//		
//		// Act
//		result = calc.verifyString("1,2,3,4,5");
//		
//		// Assert
//		assertEquals(false, result);
//	}
	
	@Test
	public void testVerifyString_ValidNewline() {
		// Arrange
		StringCalculator calc = new StringCalculator();
		boolean result = false;
		
		// Act
		result = calc.verifyString("1\n2");
		
		// Assert
		assertEquals(true, result);
	}
	
	@Test
	public void testAdd_12_3() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		int result = 0;
		
		// Act
		result = calc.add("1\n2");
		
		// Assert
		assertEquals(3, result);
	}
	
	@Test
	public void testAdd_Empty() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		int result = 0;
		
		// Act
		result = calc.add("");
		
		// Assert
		assertEquals(0, result);
	}
	
	@Test
	public void testAdd_1234_10() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		int result = 0;
		
		// Act
		result = calc.add("1\n2,3\n4");
		
		// Assert
		assertEquals(10, result);
	}
	
	@Test
	public void testAdd_SumOfOneNumber() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		int result = 0;
		
		// Act
		result = calc.add("1234");
		
		// Assert
		assertEquals(1234, result);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAdd_Exception() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		
		// Act
		// This statement should cause an exception
		calc.add("hello there");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAdd_DoubleDelimiter() throws StringCalculatorException {
		// Arrange
		StringCalculator calc = new StringCalculator();
		
		// Act
		// This statement should cause an exception
		calc.add("1,\n2");
	}

}
