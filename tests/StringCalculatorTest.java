import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void initializeStringCalculator() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void testAdd_2NumbersString() throws StringCalculatorException {
		//Arrange
		String twoNumberString = "42,42";
		//Act
		int returnedNumber = stringCalculator.add(twoNumberString);
		//Assert
		assertEquals("Returned number should be equal to the sum of the numbers in the string", 84, returnedNumber);
	}

	@Test
	public void testAdd_2NumbersStringWithWhiteSpace() throws StringCalculatorException {
		//Arrange
		String twoNumberString = "42, 42";
		//Act
		int returnedNumber = stringCalculator.add(twoNumberString);
		//Assert
		assertEquals("Returned number should be equal to the sum of the numbers in the string", 84, returnedNumber);
	}

	@Test
	public void testAdd_1NumberString() throws StringCalculatorException {
		//Arrange
		String singleNumberString = "42";
		//Act
		int returnedNumber = stringCalculator.add(singleNumberString);
		//Assert
		assertEquals("Returned number should be equal to given number.", Integer.parseInt(singleNumberString), returnedNumber);
	}

	@Test
	public void testAdd_NullString() throws StringCalculatorException {
		//Arrange
		String nullString = null;
		//Act
		int returnedNumber = stringCalculator.add(nullString);
		//Assert
		assertEquals("Returned number should be 0", 0, returnedNumber);
	}

	@Test
	public void testAdd_EmptyString() throws StringCalculatorException {
		//Arrange
		String emptyString = "";
		//Act
		int returnedNumber = stringCalculator.add(emptyString);
		//Assert
		assertEquals("Returned number should be 0", 0, returnedNumber);
	}

	@Test
	public void testAdd_3NumbersStringWithWhitespace() throws StringCalculatorException {
		//Arrange
		String threeNumberString = "42,42, 42";
		//Act
		int returnedNumber = stringCalculator.add(threeNumberString);
		//Assert
		assertEquals("Returned number should be equal to the sum of the numbers in the string", 126, returnedNumber);
	}

	@Test
	public void testAdd_stringWithNewLines() throws StringCalculatorException {
		//Arrange
		String threeNumberString = "42,42\n42";
		//Act
		int returnedNumber = stringCalculator.add(threeNumberString);
		//Assert
		assertEquals("Returned number should be equal to the sum of the numbers in the string", 126, returnedNumber);
	}

	@Test (expected = StringCalculatorException.class)
	public void testAdd_NegativeNumber() throws StringCalculatorException {
		//Arrange
		String negativeNumberString = "-1";
		//Act
		int returnedNumber = stringCalculator.add(negativeNumberString);
	}

	@Test (expected = StringCalculatorException.class)
	public void testAdd_InvalidInput() throws StringCalculatorException {
		//Arrange
		String invalidNumberString = "Hello there!";
		//Act
		int returnedNumber = stringCalculator.add(invalidNumberString);
	}

}
