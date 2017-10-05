import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void TestStringAdd() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		assertEquals(calc.add("1,2,3"), 6);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void TestStringAddBadInput() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		assertEquals(calc.add("1,\n2 3"), 6);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void TestStringAddNegativeNumber() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		assertEquals(calc.add("1,\n2 -3"), 6);
	}
	
	@Test
	public void TestStringAddEmptyString() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		assertEquals(calc.add(""), 0);
	}
	
	@Test
	public void TestInputVerifier() {
		StringCalculator calc = new StringCalculator();

		assertEquals(calc.verifyInput(null), false);
		assertEquals(calc.verifyInput(""), false);
		assertEquals(calc.verifyInput("test"), false);
		assertEquals(calc.verifyInput("te6st"), false);
		assertEquals(calc.verifyInput("1,2,3"), true);
		assertEquals(calc.verifyInput("1\n2\n3"), true);
		assertEquals(calc.verifyInput("1, 2, 3"), false);
		assertEquals(calc.verifyInput("1,\n"), false);
		assertEquals(calc.verifyInput("1,\n2"), false);
	}
	
	@Test
	public void testStringSplitterOutput() {
		StringCalculator calc = new StringCalculator();
		
		String[] testArray = {"1", "2", "3"};
		
		String[] outputArray = calc.splitString("1,2,3");
		
		assertArrayEquals(outputArray, testArray);
		
		outputArray = calc.splitString("1\n2\n3\n");
		
		assertArrayEquals(outputArray, testArray);
		
		outputArray = calc.splitString("1.2.3");
		
		assertFalse(outputArray == testArray);
	}
	
	@Test
	public void testContainsNumber() {
		StringCalculator calc = new StringCalculator();
		
		assertEquals(calc.ContainsNumber("asdbii\\n1"), true);
		assertEquals(calc.ContainsNumber("asdbii\\n"), false);
	}

}
