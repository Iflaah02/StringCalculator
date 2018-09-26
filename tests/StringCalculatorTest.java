import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator sc;
	
	@Before
	public void init() {
		sc = new StringCalculator();
	}
	
	@Test
	public void empty_string() throws StringCalculatorException {
		assertEquals(0, sc.add(""));
	}
	
	@Test
	public void single_number() throws StringCalculatorException {
		assertEquals(5, sc.add("5"));
		assertEquals(12, sc.add("12"));
	}
	
	@Test
	public void two_numbers() throws StringCalculatorException {
		assertEquals(12, sc.add("5,7"));
		assertEquals(3, sc.add("1,2"));
		assertEquals(2, sc.add("0,2"));
	}
	
	@Test
	public void more_than_two_numbers() throws StringCalculatorException {
		assertEquals(11, sc.add("1,7,3"));
		assertEquals(0, sc.add("0,0,0"));
		assertEquals(17, sc.add("5,7,3,2"));
	}
	
	@Test(expected = StringCalculatorException.class)
	public void single_not_number() throws StringCalculatorException {
		sc.add("abc");
		
	}
	
	@Test(expected = StringCalculatorException.class)
	public void single_not_number2() throws StringCalculatorException {
		sc.add(",");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_not_number() throws StringCalculatorException {
		sc.add("abc,def");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_not_number2() throws StringCalculatorException {
		sc.add("24,def");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_not_number3() throws StringCalculatorException {
		sc.add("abc,12");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void single_negative_number() throws StringCalculatorException {
		sc.add("-5");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void single_negative_number2() throws StringCalculatorException {
		sc.add("-0");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_negative_numbers() throws StringCalculatorException {
		sc.add("-5,-8");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_negative_numbers2() throws StringCalculatorException {
		sc.add("-5,8");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void two_negative_numbers3() throws StringCalculatorException {
		sc.add("5,-8");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void more_than_two_negative_numbers() throws StringCalculatorException {
		sc.add("-5,-8,2,-1");
	}
	
	@Test(expected = StringCalculatorException.class)
	public void more_than_two_negative_numbers2() throws StringCalculatorException {
		sc.add("-5,-8,-2,-1");
	}
	
	@Test
	public void two_numbers_line_break() throws StringCalculatorException {
		assertEquals(12, sc.add("5\n7"));
		assertEquals(7, sc.add("0\n7"));
	}
	
	@Test
	public void more_than_two_numbers_line_break() throws StringCalculatorException {
		assertEquals(14, sc.add("5\n7,2"));
		assertEquals(14, sc.add("5,7\n2"));
		assertEquals(14, sc.add("5\n7\n2"));
	}
}
