import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StringCalculatorTest {

	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	
	@Test
	public void testGetArrayFromString_0_1() {
		//Arrange 
		String numbersStr = "0,1";
		ArrayList<String> numbers = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		String[] expectedOutput = {"0", "1"}; 
		
		//Act 
		numbers = calc.getArrayFromString(numbersStr); 
		
		//Assert
		assertArrayEquals(expectedOutput, numbers.toArray());
	}
	
	@Test
	public void testGetArrayFromString_1() {
		//Arrange 
		String numbersStr = "1";
		ArrayList<String> numbers = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		String[] expectedOutput = {"1"}; 
		
		//Act 
		numbers = calc.getArrayFromString(numbersStr); 
		
		//Assert
		assertArrayEquals(expectedOutput, numbers.toArray());
	}
	
	@Test
	public void testGetArrayFromString_EmptyString() {
		//Arrange 
		String numbersStr = "";
		ArrayList<String> numbers = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		String[] expectedOutput = {"0"}; 
		
		//Act 
		numbers = calc.getArrayFromString(numbersStr); 
		
		//Assert
		assertArrayEquals(expectedOutput, numbers.toArray());
	}
	
	@Test
	public void testGetArrayFromString_0_1_2_3_4_5_6() {
		//Arrange 
		String numbersStr = "0,1,2,3,4,5,6";
		ArrayList<String> numbers = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		String[] expectedOutput = {"0", "1", "2", "3", "4", "5", "6"}; 
		
		//Act 
		numbers = calc.getArrayFromString(numbersStr); 
		
		//Assert
		assertArrayEquals(expectedOutput, numbers.toArray());
	}
	
	@Test
	public void testConvertArray_0_1() {
		//Arrange 
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("0"); 
		stringArray.add("1");
		
		StringCalculator calc = new StringCalculator(); 
		
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		ArrayList<Integer> expectedOutput = new ArrayList<Integer>(); 
		expectedOutput.add(0); 
		expectedOutput.add(1);
		
		
		//Act 
		try {
			integerArray = calc.convertArrayList(stringArray);
		} catch (StringCalculatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//Assert
		assertArrayEquals(expectedOutput.toArray(), integerArray.toArray());
	}
	
	@Test
	public void testCalculateSum_3_4() {
		//Arrange 
		ArrayList<Integer> integerArray = new ArrayList<Integer>(); 
		integerArray.add(3); 
		integerArray.add(4);
		
		StringCalculator calc = new StringCalculator(); 
		
		int expectedSum = 7;
		
		//Act 
		int result = calc.calculateSum(integerArray); 
		
		//Assert
		assertEquals(expectedSum, result);
	}
	
	@Test
	public void testCalculateSum_0_0() {
		//Arrange 
		ArrayList<Integer> integerArray = new ArrayList<Integer>(); 
		integerArray.add(0); 
		integerArray.add(0);
		
		StringCalculator calc = new StringCalculator(); 
		
		int expectedSum = 0;
		
		//Act 
		int result = calc.calculateSum(integerArray); 
		
		//Assert
		assertEquals(expectedSum, result);
	}
	
	
	@Test
	public void testGetArrayFromString_NewLine() {
		//Arrange 
		String numbersStr = "1\n2,3";
		ArrayList<String> numbers = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		String[] expectedOutput = {"1", "2", "3"}; 
		
		//Act 
		numbers = calc.getArrayFromString(numbersStr); 
		
		//Assert
		assertArrayEquals(expectedOutput, numbers.toArray());
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testConvertArray_Letter_StringCalculatorException() throws StringCalculatorException {
		//Arrange 
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("0"); 
		stringArray.add("a");
		
		StringCalculator calc = new StringCalculator(); 
		
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		//Act 
		integerArray = calc.convertArrayList(stringArray);
	}
	
	@Test(expected = StringCalculatorException.class)
	public void testConvertArray_DoubleValue_StringCalculatorException() throws StringCalculatorException {
		//Arrange 
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("0"); 
		stringArray.add("2.34");
		
		StringCalculator calc = new StringCalculator(); 
		
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		//Act 
		integerArray = calc.convertArrayList(stringArray);
	}
	
	
	@Test(expected = StringCalculatorException.class)
	public void testConvertArray_NegativeNumber_StringCalculatorException() throws StringCalculatorException {
		//Arrange 
		ArrayList<String> stringArray = new ArrayList<String>();
		stringArray.add("0"); 
		stringArray.add("-1");
		
		StringCalculator calc = new StringCalculator(); 
		
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		//Act 
		integerArray = calc.convertArrayList(stringArray);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testInvalidInput_Comma_NewLine() throws StringCalculatorException{
		//Arrange 
		String numbersStr = "1,\n";
		ArrayList<String> stringArray = new ArrayList<String>();
		StringCalculator calc = new StringCalculator(); 
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		
		//Act 
		stringArray = calc.getArrayFromString(numbersStr); 
		integerArray = calc.convertArrayList(stringArray); 
	}
	
	@Test 
	public void testAdd_1_5_6_1_0() {
		//Arrange
		String numbersStr = "1,5,6,1,0"; 
		int result; 
		StringCalculator calc = new StringCalculator(); 
		
		//Act
		result = calc.add(numbersStr); 
		
		//Assert
		assertEquals(13, result); 
	}
	
	@Test 
	public void testAdd_EmptyString() {
		//Arrange
		String numbersStr = ""; 
		int result; 
		StringCalculator calc = new StringCalculator(); 
		
		//Act
		result = calc.add(numbersStr); 
		
		//Assert
		assertEquals(0, result); 
	}
	
	
	

}
