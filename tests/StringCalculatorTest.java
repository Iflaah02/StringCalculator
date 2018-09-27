import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	// Requirement 1:
	
	@Test
	public void test_emptyString_returnsZero() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("");
		assertEquals(0, result);
	}
	
	@Test
	public void test_singleDigitString_returnsParsedNumber() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1");
		assertEquals(1, result);
	}

	@Test
	public void test_multiDigitString_returnsParsedNumber() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("599599");
		assertEquals(599599, result);
	}
	
	@Test
	public void test_twoNumbersByComma_returnsTheirSum() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("2,3");
		assertEquals(5, result);
	}
	
	@Test
	public void test_threeNumbersByComma_returnsTheirSum() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("3,4,5");
		assertEquals(12, result);
	}
	
	// Requirement 2:
	
	@Test
	public void test_add_fiveNumbersByComma_returnsTheirSum() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("5,4,3,2,1");
		assertEquals(15, result);
	}
	
	@Test
	public void test_add_tenNumbersByComma_returnsTheirSum() throws StringCalculatorException {
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
	public void test_parseStringsToIntegers_emptyList() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String[] strings = new String[0];
		int[] result = calc.parseAndValidateStrings(strings);
		assertEquals(0, result.length);
	}
	
	@Test
	public void test_parseStringsToIntegers_parsesIntegersCorrectly() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String[] strings = {"10", "25", "3"};
		int[] result = calc.parseAndValidateStrings(strings);
		assertEquals(10, result[0]);
		assertEquals(25, result[1]);
		assertEquals(3, result[2]);
	}
	
	// Requirement 3:
	@Test
	public void test_countSeparatorSymbols_emptyStringReturnsZero() {
		StringCalculator calc = new StringCalculator();
		int result = calc.countSeparatorSymbols("");
		assertEquals(0, result);
	}

	@Test
	public void test_countSeparatorSymbols_countsNumberOrCommas() {
		StringCalculator calc = new StringCalculator();
		int result = calc.countSeparatorSymbols("1,2,3");
		assertEquals(2, result);
	}
	
	@Test
	public void test_countSeparatorSymbols_countsNumberOrNewlines() {
		StringCalculator calc = new StringCalculator();
		int result = calc.countSeparatorSymbols("1\n2\n3\n4");
		assertEquals(3, result);
	}
	
	@Test
	public void test_countSeparatorSymbols_countsNumberOrMixed() {
		StringCalculator calc = new StringCalculator();
		int result = calc.countSeparatorSymbols("1,2\n3\n4,5");
		assertEquals(4, result);
	}
	
	@Test
	public void test_countSeparatorSymbols_randomData() {
		StringCalculator calc = new StringCalculator();
		int result = calc.countSeparatorSymbols(",g,\nq,h4,u2,je,,\n");
		assertEquals(9, result);
	}
	
	@Test
	public void test_splitString_emptyStringReturnsEmptyArray() {
		StringCalculator calc = new StringCalculator();
		String[] result = calc.splitString("");
		assertEquals(0, result.length);
	}
	
	@Test
	public void test_splitString_splitsByBothSeparators() {
		StringCalculator calc = new StringCalculator();
		String[] result = calc.splitString("10,20\n30");
		assertEquals(3, result.length);
		assertEquals("10", result[0]);
		assertEquals("20", result[1]);
		assertEquals("30", result[2]);
	}
	
	@Test (expected = Exception.class)
	public void test_add_InvalidDataThrows() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1234\n,");
	}
	
	// Requirement 4:
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_negativeNumbers_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,4,-5,3");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_decimalNumbers_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("1,4,3.5,3");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_unknownSeparators_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("3,4,5;6");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_stackedSeparators_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("3,,4,5,6");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_garbageData_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("öZX:#)HB");
	}
	
	@Test (expected = StringCalculatorException.class)
	public void test_add_extraSpaces_Throws() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		calc.add("3, 4 ,5");
	}
	
	@Test
	public void test_add_validData_sumsCorrctly() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("15\n15,10");
		assertEquals(40, result);
	}
}


