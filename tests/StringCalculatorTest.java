import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	
	
	@Test (expected = StringCalculatorException.class)
	public void handleNumTooMany() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.handleNum("1,2,3");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void handleNumNeg() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.handleNum("-1,-2");
	}

	@Test 
	public void addEmpty() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(0, calc.add(""));
	}
	
	@Test 
	public void add12_3() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(3, calc.add("1,2"));
	}
	
	@Test 
	public void addOne() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(1, calc.add("1"));
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addAlpha() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("a,a");
	}
}
