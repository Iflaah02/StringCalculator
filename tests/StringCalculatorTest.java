import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testStringtoInt() {
		StringCalculator calc = new StringCalculator();
		assertEquals(new Integer(5), calc.stringToInt("5"));
	}
	
	@Test
	public void testcheckEmptyString() {
		StringCalculator calc = new StringCalculator();
		assertTrue(calc.checkEmptyString(""));
		assertFalse(calc.checkEmptyString(" "));
	}

	@Test
	public void testCheckValidInput() {
		StringCalculator calc = new StringCalculator();
		assertTrue(calc.checkValidInput(""));
		assertTrue(calc.checkValidInput("1,2,3,4,5"));
		assertTrue(calc.checkValidInput("5"));
		assertTrue(calc.checkValidInput("1\n2"));
		assertFalse(calc.checkValidInput(",1,2,3,4"));
		assertFalse(calc.checkValidInput("2\n"));
		assertFalse(calc.checkValidInput(","));
		assertFalse(calc.checkValidInput("1,"));
		assertFalse(calc.checkValidInput("\n1\2n"));
		assertFalse(calc.checkValidInput("a"));
		assertFalse(calc.checkValidInput("-1"));
	}

	@Test (expected = StringCalculatorException.class)
	public void testHandleNegativeNumbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> integers = new ArrayList<Integer>();
		
		integers.add(1);
		calc.handleNegativeNumbers(integers);
		integers.add(2);
		calc.handleNegativeNumbers(integers);
		integers.add(0);
		calc.handleNegativeNumbers(integers);
		integers.add(-1);
		// This should throw an exception
		calc.handleNegativeNumbers(integers);
	}
	
	@Test
	public void testGetUnknownAmountOfNumbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		assertEquals(integers, calc.getUnknownAmountOfNumbersFromString("1,2,3,4,5"));
	}
	
	@Test
	public void testGetMaxTwoNumbersFromString() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(1,2));
		assertEquals(integers, calc.getMaxTwoNumbersFromString("1,2"));
	}
	
	@Test
	public void testAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(0, calc.add(""));
		assertEquals(3, calc.add("1,2,3")); // this is ok as the method only handles the first 2 numbers
	}
	
	@Test
	public void testAddUnknown() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(15, calc.addUnknown("1,2,3,4,5"));
		assertEquals(0, calc.addUnknown(""));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void testAddFailureOnMalformedInput() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1");
		// This should throw an exception
		calc.add("a");
	}

}