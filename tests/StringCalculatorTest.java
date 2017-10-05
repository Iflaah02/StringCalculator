import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test (expected = StringCalculatorException.class)
	public void addTest_emptyString() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "";
		
		int value = calc.add(str);
		
		assertEquals("Incorrect sum for empty string", 0, value);
		
	}
	
	@Test
	public void addTest_oneValue() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "32";
		
		int value = calc.add(str);
		
		assertEquals("Incorrect sum for one value string", 32, value);
		
	}
	
	@Test
	public void addTest_twoValues() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "2,15";
		
		int value = calc.add(str);
		
		assertEquals("Incorrect sum for two value string", 17, value);
		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addTest_negativeValues() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "7,-33";
		
		calc.add(str);
		
	}
	
	@Test (expected = StringCalculatorException.class)
	public void addTest_alphabeticValues() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "7,ad4,3";
		
		calc.add(str);
		
	}
	
	@Test
	public void validateSubstringTest_alphanumbericValues() {
		StringCalculator calc = new StringCalculator();
		String str = "432g";
		
		boolean value = calc.validateSubstring(str);
		
		assertEquals("Incorrect sum for two value string", false, value);
		
	}
	
	@Test 
	public void validateSubstringTest_positiveNumber() {
		StringCalculator calc = new StringCalculator();
		String str = "55";
		
		boolean value = calc.validateSubstring(str);
		
		assertEquals("Incorrect sum for two value string", true, value);
	}
	
	@Test 
	public void validateSubstringTest_negativeNumber() {
		StringCalculator calc = new StringCalculator();
		String str = "-3";
		
		boolean value = calc.validateSubstring(str);
		
		assertEquals("Incorrect sum for two value string", true, value);
	}
	
	@Test 
	public void separateSubstringsTest_fourCommas() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "4,62,7634,1";
		
		String[] value = calc.separateNumbers(str);
		
		assertEquals("Incorrect 1st item",       "4",    value[0]);
		assertEquals("Incorrect 2nd item",       "62",   value[1]);
		assertEquals("Incorrect 3rd item",       "7634", value[2]);
		assertEquals("Incorrect 4th item",       "1",    value[3]);
		assertEquals("Incorrect number of items", 4,     value.length);
	}
	
	@Test 
	public void separateSubstringsTest_fourNewlines() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "4\n62\n7634\n1";
		
		String[] value = calc.separateNumbers(str);
		
		assertEquals("Incorrect 1st item",       "4",    value[0]);
		assertEquals("Incorrect 2nd item",       "62",   value[1]);
		assertEquals("Incorrect 3rd item",       "7634", value[2]);
		assertEquals("Incorrect 4th item",       "1",    value[3]);
		assertEquals("Incorrect number of items", 4,     value.length);
	}
	
	@Test 
	public void separateSubstringsTest_commasAndNewlines() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "4\n62,7634,1";
		
		String[] value = calc.separateNumbers(str);
		
		assertEquals("Incorrect 1st item",       "4",    value[0]);
		assertEquals("Incorrect 2nd item",       "62",   value[1]);
		assertEquals("Incorrect 3rd item",       "7634", value[2]);
		assertEquals("Incorrect 4th item",       "1",    value[3]);
		assertEquals("Incorrect number of items", 4,     value.length);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void separateSubstringsTest_emptyValues() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		String str = "4\n62\n,7634,1";
		
		calc.separateNumbers(str);
		
	}

	@Test (expected = StringCalculatorException.class)
	public void throwOnNegativeTest_negativeValue() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		calc.throwOnNegative(-3);
		
	}
	
	@Test
	public void throwOnNegativeTest_positiveValue() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		calc.throwOnNegative(3);
		
	}
	
	@Test
	public void throwOnNegativeTest_zeroValue() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		calc.throwOnNegative(0);
		
	}


}
