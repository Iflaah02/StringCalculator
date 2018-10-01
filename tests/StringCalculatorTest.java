import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testOneNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String[] result = {"1"};
		int[] intArray = calculator.toIntArray(result);
		int[] ints2 = {1};
		//Assert
		assertArrayEquals(intArray, ints2);
	}
	
	@Test
	public void testTwoIntNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String[] result = {"1","2"};
		int[] intArray = calculator.toIntArray(result);
		int[] ints2 = {1,2};
		//Assert
		assertArrayEquals(intArray, ints2);
	}
	
	@Test
	public void testTwoStringNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1,2";
		String[] stringArray = calculator.toStringArray(result);
		String[] stringArray2 = {"1", "2"};
		//Assert
		assertArrayEquals(stringArray, stringArray2);
	}
	
	@Test
	public void testThreeStringNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1\n2,3";
		String[] stringArray = calculator.toStringArray(result);
		String[] stringArray2 = {"1","2","3"};
		//Assert
		assertArrayEquals(stringArray, stringArray2);
	}
	
	@Test
	public void testLineBreak() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1\n2,3";
		String string = calculator.handleLineBreakAndComma(result);
		String string2 = "1,2,3";
		//Assert
		assertEquals(string, string2);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testComma() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1,\n2,3";
		// This statement should cause an exception
		calculator.handleLineBreakAndComma(result);
	}
	@Test
	public void testEmptyString() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "0";
		String string = calculator.handleEmptyString(result);
		String string2 = "";
		//Assert
		assertEquals(string, string2);
		System.out.println(string);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testUnknowNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1,2,3";
		// This statement should cause an exception
		calculator.handleUnknownNumbers(result);
	}
	@Test (expected = StringCalculatorException.class)
	public void testAlphapeticAndNegative() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "A";
		// This statement should cause an exception
		calculator.handleAlphabeticAndNegative(result);
	}
	@Test (expected = StringCalculatorException.class)
	public void testAlphapeticAndNegative2() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "-2";
		// This statement should cause an exception
		calculator.handleAlphabeticAndNegative(result);
		System.out.println(result);
	}
	
	@Test
	public void testAddLineBreak() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1\n2,3";
		int toInt = calculator.add(result);
		int sum = 6;
		//Assert
		assertEquals(toInt, sum);
	}
	@Test
	public void testAddTwoNumbers() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "1,2";
		int toInt = calculator.add(result);
		int sum = 3;
		//Assert
		assertEquals(toInt, sum);
	}
	@Test
	public void testAddZeroAndNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "0,2";
		int toInt = calculator.add(result);
		int sum = 2;
		//Assert
		assertEquals(toInt, sum);
	}
	@Test
	public void testAddOneNumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//Act
		String result = "2";
		int toInt = calculator.add(result);
		int sum = 2;
		//Assert
		assertEquals(toInt, sum);
	}
}
