import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void test_getArrayInteger_13_14_comma() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "13,14";
		
		Integer[] res = new Integer[] {13, 14};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(res));
		
		//Act
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
		//Assert
		assertEquals(expected ,intArray);
	}
	
	@Test
	public void test_getArrayInteger_8_9_newline() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "8\n9";
		
		Integer[] res = new Integer[] {8, 9};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(res));
		
		//Act
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
		//Assert
		assertEquals(expected ,intArray);
	}
	
	@Test
	public void test_getArrayInteger_3_12_28_mix() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "3\n12,28";
		
		Integer[] res = new Integer[] {3, 12, 28};
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(res));
		
		//Act
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
		//Assert
		assertEquals(expected ,intArray);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_getArrayInteger_throw_exception_notnumber() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "3.14\n12,28";
		
		//Act - should cause exception
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_getArrayInteger_throw_exception_invaliddelimiter() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "2,\n3";
		
		//Act - should cause exception
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_getArrayInteger_throw_exception_negative() throws StringCalculatorException {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		String str = "2,-7\n3";
		
		//Act - should cause exception
		ArrayList<Integer> intArray = calculator.getArrayInteger(str);
		
	}
	
	@Test
	public void test_CalculateSum_5_9() {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		
		Integer[] input = new Integer[] {5, 9};
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(input));
		
		//Act
		int result = calculator.calculateSum(inputArray);
		
		//Assert
		assertEquals(14 ,result);
	}
	
	@Test
	public void test_CalculateSum_3_12_28() {
		//Arrange
		StringCalculator calculator = new StringCalculator();
		
		Integer[] input = new Integer[] {3, 12, 28};
		ArrayList<Integer> inputArray = new ArrayList<Integer>(Arrays.asList(input));
		
		//Act
		int result = calculator.calculateSum(inputArray);
		
		//Assert
		assertEquals(43 ,result);
	}

}
