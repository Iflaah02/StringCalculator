import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void addEmpty() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 0, calc.add(""));
	}
	
	@Test
	public void addOne() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 7, calc.add("7"));
	}
	
	@Test
	public void addTwo() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 6, calc.add("1,5"));
	}
	
	@Test
	public void addThree() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 10, calc.add("2,3,5"));
	}
	
	@Test
	public void addMultiDigitNumbers() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 1111, calc.add("111,999,1"));
	}
	
	@Test
	public void addMoreThanThreeNumbers() {
		StringCalculator calc = new StringCalculator();
		assertEquals("Error with empty string", 80, calc.add("7,3,50,12,8"));
	}
}
