import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	// Requirement 1:
	
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
	
	// Requirement 2:
	
	@Test
	public void test_add_fiveNumbersByComma_returnsTheirSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("5,4,3,2,1");
		assertEquals(15, result);
	}
	
	@Test
	public void test_add_tenNumbersByComma_returnsTheirSum() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,10,100,1000,10000,1,10,100,1000,10000");
		assertEquals(22222, result);
	}
	
	@Test
	public void test_sumNumbers_retunsZeroFromEmptyList() {
		StringCalculator calc = new StringCalculator();
		int[] numbers = new int[0];
		int result = calc.sumNumbers(numbers);
		assertEquals(0, result);
	}
	
	@Test
	public void test_sumNumbers_singleIntegerReturnsSameValue() {
		StringCalculator calc = new StringCalculator();
		int[] numbers = {5000};
		int result = calc.sumNumbers(numbers);
		assertEquals(5000, result);
	}
	
	@Test
	public void test_sumNumbers_sumsThreeIntegersCorrectly() {
		StringCalculator calc = new StringCalculator();
		int[] numbers = {3, 5, -4};
		int result = calc.sumNumbers(numbers);
		assertEquals(4, result);
	}
	
	@Test
	public void test_parseStringsToIntegers_emptyList() {
		StringCalculator calc = new StringCalculator();
		String[] strings = new String[0];
		int[] result = calc.parseStringsToIntegers(strings);
		assertEquals(0, result.length);
	}
	
	@Test
	public void test_parseStringsToIntegers_parsesIntegersCorrectly() {
		StringCalculator calc = new StringCalculator();
		String[] strings = {"10", "25", "3"};
		int[] result = calc.parseStringsToIntegers(strings);
		assertEquals(10, result[0]);
		assertEquals(25, result[1]);
		assertEquals(3, result[2]);
	}
}
