import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	// A test for the seventh slice
	@Test
	public void testSettingNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "1234";
		
		//Act
		int additionResult = calc.add(input);
		
		//Assert
		assertEquals(input, String.valueOf(calc.getString()));
	}

	
	// A test for the first slice
	@Test
	public void testAddingSingleNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "76";
		
		//Act
		int result = calc.add(input);
		
		//Assert
		assertEquals(input, String.valueOf(result));
	}
	
	// A test for the second slice
	@Test
	public void testAddingThreeNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "20,37,39";
		int expectedResult = 20 + 37 + 39;
		
		//Act
		int result = calc.add(input);
		
		//Assert
		assertEquals(expectedResult, result);
	}
	
	// A test for the third slice
	@Test (expected = StringCalculatorException.class)
	public void testAddingLetters() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "3,40,abc";
		
		//Act
		int result = calc.add(input);
	}
	
	// A test for the fourth slice
	@Test (expected = StringCalculatorException.class)
	public void testAddingNegativeNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "-100,2,65";
		
		//Act
		int result = calc.add(input);
	}
	
	// A test for the fifth slice
	@Test
	public void testAddingNewlinesAndCommas() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "123,40\n30";
		int expectedResult = 123 + 40 + 30;
		
		//Act
		int result = calc.add(input);
		
		//Assert
		assertEquals(expectedResult, result);
	}
	
	// A test for the sixth slice
	@Test (expected = StringCalculatorException.class)
	public void testConsecutiveCommaAndNewline() throws StringCalculatorException {
		//Arrange
		StringCalculator calc = new StringCalculator();
		String input = "1,\n";
		
		//Act
		int result = calc.add(input);
		System.out.println(result);
	}

}
