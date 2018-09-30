import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testNonNumbersInString() {
		StringCalculator CharCheck = new StringCalculator();
		boolean number = CharCheck.calculateStringNumbersSize("1,2,3,4");
		assertTrue(number = false);
	}
	
	@Test
	public void testRemoveLine() {
		StringCalculator CharCheck = new StringCalculator();
		String number = CharCheck.removeLine("1,2,3\n");
		assertTrue(number == "1,2,3");
	}
	
	@Test
	public void testExplicitNumbers() {
		StringCalculator CharCheck = new StringCalculator();
		String number = CharCheck.explicitNumbers("1,2...3");
		assertTrue(number == "1,2,3");
	}
	
	@Test
	public void testStringCalculator() {
		StringCalculator CharCheck = new StringCalculator();
		//int number = CharCheck.add("1,2,3");
		assertEquals(6, CharCheck.add("1,2,3"));
	}
	

}
