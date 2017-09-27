import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testStringCalculator_canTake0Numbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add(""), 0);
	}
	
	@Test
	public void testStringCalculator_canTake1Number() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add("1"), 1);
	}
	
	@Test
	public void testStringCalculator_canTake2Numbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add("1,2"), 3);
	}
	
	@Test
	public void testStringCalculator_canTake5Numbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add("1,2,3,4,5"), 15);
	}
	
	@Test
	public void testStringCalculator_canTake10Numbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add("10,10,10,10,10,10,10,100,1000,10000"), 11170);
	}
	
	@Test
	public void testStringCalculator_canHandleNewlineSeparators() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		assertEquals(calc.add("1\n2,3,4\n5"), 15);
	}
	
	@Test
	public void testStringCalculator_throwsExceptionForConsecutiveDelimiters() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add("1\n,");
			fail("Double delimiters did not throw an exception");
		}
		catch (StringCalculatorException e) {
			// Pass
		}
	}
	
	@Test
	public void testStringCalculator_throwsExceptionForLeadingDelimiter() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add(",1,2");
			fail("Leading delimiter did not throw an exception");
		}
		catch (StringCalculatorException e) {
			// Pass
		}
	}
	
	@Test
	public void testStringCalculator_throwsExceptionForTrailingDelimiter() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add("1,2\n");
			fail("Trailing delimiter did not throw an exception");
		}
		catch (StringCalculatorException e) {
			// Pass
		}
	}
	
	@Test
	public void testStringCalculator_throwsExceptionForStrings() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add("1,cat");
			fail("Adding an integer and a string did not throw an exception");
		}
		catch (StringCalculatorException e) {
			// Pass
		}
	}
	
	@Test
	public void testStringCalculator_throwsExceptionForNegativeIntegers() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add("-1,-1");
			fail("Adding negative integers did not throw an exception");
		}
		catch (StringCalculatorException e) {
			// Pass
		}
	}
}
