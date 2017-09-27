import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testSplit() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1,2");
		int splitLength = calculator.splitLength;
		assertEquals(2, splitLength);

	}

	@Test
	public void testSplit1() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("1");
		int splitLength = calculator.splitLength;
		assertEquals(1, splitLength);

	}

	@Test
	public void testSplit0() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("");
		int splitLength = calculator.splitLength;
		assertEquals(1, splitLength);

	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testSum() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5,2,7");

		int sumOfNumbers = calculator.sumOfNumbers();
		assertEquals(14, sumOfNumbers);
	}

	@Test
	public void testnewLine() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5,2");
		calculator.newLines();

		int withNewLine = calculator.lengthNumbers;
		assertEquals(2, withNewLine);
	}

	@Test
	public void testnewLine2() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();
		calculator.add("5\n3,2");
		calculator.newLines();

		int withNewLine = calculator.lengthNumbers;
		assertEquals(3, withNewLine);
	}

	@Test(expected = StringCalculatorException.class)
	public void testnewLineError() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		calculator.newError("5,\n");

	}

	@Test(expected = StringCalculatorException.class)
	public void testErrorMinus() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		calculator.newError("5,-5");

	}

	@Test(expected = StringCalculatorException.class)
	public void testErrorNoNumber() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		calculator.add("gel");
		int sum = calculator.sumOfNumbers();
		// assertEquals(3,sum);

	}

	@Test
	public void testMerge2Numbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("1,2");
		assertEquals(3, sum);
	}

	@Test
	public void testMerge3NumbersWithNewLine() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("4,7\n8,9");
		assertEquals(28, sum);
	}

	@Test
	public void testMerge0Numbers() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("");
		assertEquals(0, sum);
	}

	@Test(expected = StringCalculatorException.class)
	public void testMerge2NumbersWithError1() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("-1,3");
		// assertEquals(0,sum);
	}

	@Test(expected = StringCalculatorException.class)
	public void testMerge2NumbersWithError2() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("1,\n3");
		// assertEquals(0,sum);
	}

	@Test(expected = StringCalculatorException.class)
	public void testMerge2NumbersWithError3() throws StringCalculatorException {
		StringCalculator calculator = new StringCalculator();

		int sum = calculator.add("er3,2");
		// assertEquals(0,sum);
	}

}
