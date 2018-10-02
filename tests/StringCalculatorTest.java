import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void test_add_valid() throws StringCalculatorException{
		// Arrange
		StringCalculator calculator = new StringCalculator();
		String testString = "11, 2, , 3, 31";
		
		// Act
		int returnedValue = calculator.add(testString);
		
		// Assert
		assertEquals(47, returnedValue);
	}

	@Test
	public void test_add_with_zero() throws StringCalculatorException{
		// Arrange			
		StringCalculator calculator = new StringCalculator();
		String testString = "0, 2, , 3";
		
		// Act
		int returnedValue = calculator.add(testString);
		
		// Assert
		assertEquals(5, returnedValue);
	}
	
	@Test
	public void test_add_zero() throws StringCalculatorException{
		// Arrange	
		StringCalculator calculator = new StringCalculator();
		String testString = "0, ";
		
		// Act
		int returnedValue = calculator.add(testString);
		
		// Assert
		assertEquals(0, returnedValue);
	}

	@Test  (expected = StringCalculatorException.class)
	public void test_add_empty() throws StringCalculatorException{
		// Arrange	
		StringCalculator calculator = new StringCalculator();
		String testString = " ";
		
		// Act
		int returnedValue = calculator.add(testString);
	}

	@Test
	public void test_add_null() throws StringCalculatorException{
		// Arrange	
		StringCalculator calculator = new StringCalculator();
		
		// Act
		int returnedValue = calculator.add(null);
		
		// Assert
		assertEquals(0, returnedValue);
	}
	
	@Test
	public void test_removeEmptyString() {
		// Arrange
		StringCalculator calculator = new StringCalculator();
		String[] testArray = {"21", "1", "", "15"};
		
		// Act
		String[] returnedArray = calculator.removeEmptyStrings(testArray);
		
		// Assert
		String[] expectedArray = {"21", "1", "15"};
		assertArrayEquals(returnedArray, expectedArray);
	}
	
	@Test
	public void test_convertToArray() {
		// Arrange
		StringCalculator calculator = new StringCalculator();
		String testString = "1,15\n , ,3";
		
		// Act
		String[] returnedArray = calculator.convertToNumberStringArray(testString);
		
		// Assert
		String[] expectedArray = {"1", "15", "", "3"};
		assertArrayEquals(returnedArray, expectedArray);
	}
	
	
	@Test 
	public void test_add_plainString() throws StringCalculatorException{
		// Arrange
		StringCalculator calculator = new StringCalculator();
		String testString = "1,40\n, 3";
		
		// Act
		int returnedValue = calculator.add(testString);
		
		// Assert
		int expected = 44;
		assertEquals(expected, returnedValue);
		
	}
	
	@Test 
	public void test_add_plainStringWithEmpty() throws StringCalculatorException{
		// Arrange
		StringCalculator calculator = new StringCalculator();
		String testString = " , 2\n , , , , ";
		
		// Act
		int returnedValue = calculator.add(testString);
		
		// Assert
		int expected = 2;
		assertEquals(expected, returnedValue);
		
	}
}
