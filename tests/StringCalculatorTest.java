import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test (expected = StringCalculatorException.class)
	public void addZeroNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "";
		
		//Act
		int result = calculator.add(input);	
	}
	
	@Test
	public void addOneNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "10";
		
		//Act
		int result = calculator.add(input);
		
		// Assert
		assertEquals("Sum is incorrect", 10, result);		
	}
	
	@Test
	public void addTwoNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "1,10";
		
		//Act
		int result = calculator.add(input);
		
		// Assert
		assertEquals("Sum is incorrect", 11, result);		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addNegativeNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "-1,5";
		
		//Act
		int result = calculator.add(input);	
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addLettersInInput() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "34d";
		
		//Act
		int result = calculator.add(input);	
	}
	
	@Test 
	public void splitInputTest() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "2\n15,6";
		
		//Act
		String[] result = calculator.splitInput(input);
		
		// Assert
		assertEquals("First value error", "2", result[0]);
		assertEquals("Second value error", "15", result[1]);	
		assertEquals("Third value error", "6", result[2]);	
	}
	
	@Test  (expected = StringCalculatorException.class)
	public void splitInputEmptyline() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "1\n,\n2,3";
		
		//Act
		String[] result = calculator.splitInput(input);	
	}
	
	@Test 
	public void validateNumberInteger() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "12";
		
		//Act
		boolean result = calculator.validateNumber(input);
		
		// Assert
		assertEquals("Validation error", true, result);		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void validateNumberLetter() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "f";
		
		//Act
		boolean result = calculator.validateNumber(input);
	}
	
	@Test 
	public void validateNegative_PostiveNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		int number = 55;
		
		//Act
		boolean result = calculator.validateNonNegative(number);
		
		// Assert
		assertEquals("Validation error", true, result);		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void validateNegative_NegativeNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		int number = -10;
		
		//Act
		boolean result = calculator.validateNonNegative(number);
	}
	
	@Test 
	public void transferToIntTest() {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String input = "55";
		
		//Act
		int result = calculator.transferToInt(input);
		
		// Assert
		assertEquals("Validation error", 55, result);		
	}
	
}
