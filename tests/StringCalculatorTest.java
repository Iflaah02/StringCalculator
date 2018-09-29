import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void simpleAddition() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		assertEquals("output is correct", 12, st1.add("1236"));
	}

	@Test
	public void additionWithComma() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		assertEquals("output is correct", 12, st1.add("1,2,36"));
	}

	@Test
	public void additionWithNewLine() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		assertEquals("output is correct", 12, st1.add("1,2\n36"));
	}

	@Test
	public void checkInValidAgainstnewlineWithcomma() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		boolean res = st1.isValid("45,\n67");
		assertTrue("String is Invalid", res);
	}

	@Test
	public void checkInValidAgainstNegativeNumber() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		boolean res = st1.isValid("45-67");
		assertTrue("String is Invalid", res);
	}
	
	@Test
	public void checkInValidAgainstAnyInvalidInput() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		boolean res = st1.isValid("457bcb");
		assertTrue("String is Invalid", res);
	}

	@Test
	public void isLenghtCorrect() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		assertEquals("Length is correct", 5, st1.getLength("56556"));
	}
	@Test
	public void testLenghtLimit() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		boolean range=st1.handleLength("0463563465456760000");
		assertTrue("Length is within range", range);
	}

	@Test
	public void testEmptyResult() throws StringCalculatorException {

		StringCalculator st1 = new StringCalculator();
		assertEquals("Empty output", 0, st1.add(""));
	}

}
