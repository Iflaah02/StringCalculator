import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator stcalc; // Define an object
	
	@Before
	public void init() {
		stcalc = new StringCalculator(); // and create it
	}
	
	
	// Set of test cases below
	
	@Test
	public void test_empty_string() throws StringCalculatorException {
		assertEquals(0, stcalc.add(""));
	}
	
	@Test
	public void test_single_number() throws StringCalculatorException {
		assertEquals(10, stcalc.add("10"));
	}
	
	@Test
	public void test_two_numbers() throws StringCalculatorException {
		assertEquals(10, stcalc.add("6,4"));
		assertEquals(3, stcalc.add("1,2"));
		assertEquals(2, stcalc.add("0,2"));
	}
	
	@Test
	public void test_any_numbers() throws StringCalculatorException {
		assertEquals(8, stcalc.add("1,3,4"));
		assertEquals(0, stcalc.add("0,0,0"));
		assertEquals(10, stcalc.add("1,2,3,4"));
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_single_not_number() throws StringCalculatorException {
		stcalc.add("abc");
		
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_single_not_number2() throws StringCalculatorException {
		stcalc.add(",");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_two_not_number() throws StringCalculatorException {
		stcalc.add("abc,def");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_two_not_number2() throws StringCalculatorException {
		stcalc.add("10,aaa");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_single_negative_number() throws StringCalculatorException {
		stcalc.add("-1");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_two_negative_numbers() throws StringCalculatorException {
		stcalc.add("-1,-2");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_two_negative_numbers2() throws StringCalculatorException {
		stcalc.add("-2,4");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_two_negative_numbers3() throws StringCalculatorException {
		stcalc.add("5,-6");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void test_more_than_two_negative_numbers() throws StringCalculatorException {
		stcalc.add("-5,-8,2,-1");
	}
	
	@Test
	public void test_two_numbers_line_break() throws StringCalculatorException {
		assertEquals(10, stcalc.add("4\n6"));
		assertEquals(5, stcalc.add("0\n5"));
	}
	
	@Test
	public void more_than_two_numbers_line_break() throws StringCalculatorException {
		assertEquals(6, stcalc.add("1\n2,3"));
		assertEquals(6, stcalc.add("1,2\n3"));
		assertEquals(6, stcalc.add("1\n2\n3"));
	}
	
	// More tests can go here
	
} // End of test class