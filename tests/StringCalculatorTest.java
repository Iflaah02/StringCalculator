import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void addEmpty() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 0, calc.add(""));
	}
	
	@Test
	public void addOne() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 7, calc.add("7"));
	}
	
	@Test
	public void addTwo() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 6, calc.add("1,5"));
	}
	
	@Test
	public void addThree() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 10, calc.add("2,3,5"));
	}
	
	@Test
	public void addMultiDigitNumbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 1111, calc.add("111,999,1"));
	}
	
	@Test
	public void addMoreThanThreeNumbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 80, calc.add("7,3,50,12,8"));
	}
	
	@Test
	public void addWithEndl() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 80, calc.add("7,3\n50,12\n8"));
	}
	
	@Test
	public void addWithEndlOnly() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 174, calc.add("7\n3\n10\n154"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addWithWrongInput() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("7,4\n");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addWithWrongInput1() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("7,4,");
	}
}
