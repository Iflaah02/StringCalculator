import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test_add_emptyValues() throws StringCalculatorException {
		//Arrange
		String values = "";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 0, result);
	}
	
	@Test
	public void test_add_oneValue() throws StringCalculatorException {
		//Arrange
		String values = "1";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 1, result);
	}
	
	@Test
	public void test_add_twoValues() throws StringCalculatorException {
		//Arrange
		String values = "1,10";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 11, result);
	}
	
	@Test
	public void test_add_moreThanTwoValues() throws StringCalculatorException {
		//Arrange
		String values = "1,10,4,5,7,8";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 35, result);
	}
	
	@Test
	public void test_add_string_with_newline() throws StringCalculatorException {
		//Arrange
		String values = "1\n10\n4\n5\n7\n8";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 35, result);
	}
	
	@Test
	public void test_add_string_with_newline_and_comma() throws StringCalculatorException {
		//Arrange
		String values = "1\n10\n4,5\n7,8";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
		// Assert
		assertEquals("Result incorrect", 35, result);
	}
	
	@Test  (expected = StringCalculatorException.class)
	public void test_add_negative_numbers() throws StringCalculatorException {
		//Arrange
		String values = "1\n10\n4,5\n7,-8";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
	}
	
	@Test  (expected = StringCalculatorException.class)
	public void test_add_invalid_input() throws StringCalculatorException {
		//Arrange
		String values = "\n\n,\n";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
	}
	
	@Test  (expected = StringCalculatorException.class)
	public void test_add_invalid_input2() throws StringCalculatorException {
		//Arrange
		String values = "n";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
	}
	
	@Test  (expected = StringCalculatorException.class)
	public void test_add_invalid_input3() throws StringCalculatorException {
		//Arrange
		String values = ",";
		StringCalculator strCalculator = new StringCalculator();
		
		//Act
		int result = strCalculator.add(values);
	}
	
	

}
