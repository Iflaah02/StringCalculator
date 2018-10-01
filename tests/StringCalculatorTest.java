import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class StringCalculatorTest {

	
	
	@Test
	public void TestStringCalculator_ChangeLinesToCommas() throws StringCalculatorException{
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//act		
		assertEquals("Fail","1,2,66",calculator.LinesToCommas("1\n2,66"));//		
	}
	
	@Test(expected = StringCalculatorException.class)
	public void TestStringCalculator_CommasInaRowShouldThrowException() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.checkInvalidCommas("1,,2,3");	
	}
	
	@Test
	public void TestStringCalculator_RemoveCommas() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		
		String input=("1,2,3");
		String[] expected= {"1","2","3"};
		assertArrayEquals(expected,calculator.removeCommas(input));
		}
				
	
	@Test(expected=StringCalculatorException.class)
	public void TestStringCalculator_NotNumericThrowException() throws StringCalculatorException{
		//Arrange
		StringCalculator calculator = new StringCalculator();
		//act
		String[] input= {"a","2"};
		calculator.checkForNumeric(input);
		}
	
	@Test
	public void TestStringCalculator_ChangeToIntegerArray() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		
		String[] input= {"1","2","3"};
		int[] expected= {1,2,3};
		
		assertArrayEquals(expected,calculator.ChangeToInt(input));
		}
		
	@Test(expected = StringCalculatorException.class)
	public void TestStringCalculator_NegativeThrowsException() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		int[] input= {-2,3,5};
		calculator.checkForNegatives(input);
		}

	
	@Test (expected=StringCalculatorException.class)
	public void TestStringCalculator_TooManyNumbersThrowException() throws StringCalculatorException {
			StringCalculator calculator = new StringCalculator();
			int[] input= {1,55,5};
			calculator.checkNumberCount(input);
			}
			
	
	@Test
	public void TestStringCalculator_NoNumbersReturnsZero() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		//act
		assertEquals("Fail", 0, calculator.add(""));		
	}
	@Test
	public void TestStringCalculator_AddsGivenNumbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		//act
		assertEquals("Fail", 20, calculator.add("14,6"));		
	}
}

