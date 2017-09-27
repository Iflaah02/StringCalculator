import static org.junit.Assert.*;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class StringCalculatorTest {

	//1. Test case for method retrieving the input
	@Test
	public void testRetrieveInputFunctionality() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "999,20";
		
		// Act
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	    
		// Assert
		assertEquals("999,20", strCalc.retrieveInput());
	}
	
	//2. Test cases for method to verify the input
	@Test
	public void testVerificationInputOneDigit() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "9";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertTrue(verification);
	}
	@Test
	public void testVerificationInputMultipleDigits() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "999,20,55,800";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertTrue(verification);
	}
	@Test
	public void testVerificationInputLastCharComma() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "999,20,";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertFalse(verification);
	}
	
	@Test
	public void testVerificationInputEmpty() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertTrue(verification);
	}
	
	@Test
	public void testVerificationInputLetter() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "12,54,AA,2";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertFalse(verification);
	}
	@Test
	public void testVerificationInputDecimal() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "1.2,5";
		
		// Act
	    boolean verification = strCalc.verificationInput(input);
	    
		// Assert
		assertFalse(verification);
	}
	
	//3. Test Cases for method to split the input string
	@Test
	public void testSplitInputMultipleDigits() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
	    ArrayList<Integer> testArraylist = new ArrayList<Integer>();
	    testArraylist.add(999);
	    testArraylist.add(20);
	    testArraylist.add(55);
	    testArraylist.add(800);
		String input = "999,20,55,800";
		
		// Act
		ArrayList<Integer> splittedValue = strCalc.splitInput(input);
	    
		// Assert
		assertEquals(testArraylist,splittedValue);
	}
	@Test
	public void testSplitInputEmpty() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
	    ArrayList<Integer> testArraylist = new ArrayList<Integer>();
		String input = "";
		
		// Act
		ArrayList<Integer> splittedValue = strCalc.splitInput(input);
	    
		// Assert
		assertEquals(testArraylist,splittedValue);
	}
	
	//4. Test cases for method which sums up the digits
	@Test
	public void testSumMultipleDigits() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
	    ArrayList<Integer> testArraylist = new ArrayList<Integer>();
	    testArraylist.add(1);
	    testArraylist.add(2);
	    testArraylist.add(30);
	    testArraylist.add(4);
	    testArraylist.add(5);
		
		// Act
		int sumValues = strCalc.sumDigits(testArraylist);
	    
		// Assert
		assertEquals(42,sumValues);
	}
	@Test
	public void testSumOneDigit() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
	    ArrayList<Integer> testArraylist = new ArrayList<Integer>();
	    testArraylist.add(13);
		
		// Act
		int sumValues = strCalc.sumDigits(testArraylist);
	    
		// Assert
		assertEquals(13,sumValues);
	}
	@Test
	public void testSumDigitEmpty() {
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		ArrayList<Integer> testArraylist = new ArrayList<Integer>();
		
		// Act
		int sumValues = strCalc.sumDigits(testArraylist);
	    
		// Assert
		assertEquals(0,sumValues);
	}
	//5.
	@Test
	public void testAddMultipleDigits() throws StringCalculatorException{
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "12,54,20,2,5,5000";
		
		// Act
		int sumValues = strCalc.add(input);
		
		// Assert
		assertEquals(5093,sumValues);
	}
	@Test
	public void testAddOneDigits() throws StringCalculatorException{
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "33";
		
		// Act
		int sumValues = strCalc.add(input);
		
		// Assert
		assertEquals(33,sumValues);
	}
	public void testAddEmpty() throws StringCalculatorException{
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "";
		
		// Act
		int sumValues = strCalc.add(input);
		
		// Assert
		assertEquals(0,sumValues);
	}
	
	//6. Test case to test exception
	@Test (expected = StringCalculatorException.class)
	public void testAddFalseInputLetter() throws StringCalculatorException{
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "12,54,AA,2";
		
		// Act
		int sumValues = strCalc.add(input);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAddFalseInputNegativeDigit() throws StringCalculatorException{
		// Arrange
		StringCalculator strCalc = new StringCalculator();
		String input = "12,54,-3,2";
		
		// Act
		int sumValues = strCalc.add(input);
	}
	


}
