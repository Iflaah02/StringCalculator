import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test_emptyString_returnsZero() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("");
		assertEquals(0, result);
	}
	
	@Test
	public void test_singleDigitString_returnsParsedNumber() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1");
		assertEquals(1, result);
	}

	@Test
	public void test_multiDigitString_returnsParsedNumber() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("599599");
		assertEquals(599599, result);
	}
	
	@Test
	public void test_twoNumbersByComma_returnsTheirSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("2,3");
		assertEquals(5, result);
	}
	
	@Test
	public void test_threeNumbersByComma_returnsTheirSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("3,4,5");
		assertEquals(12, result);
	}
}
