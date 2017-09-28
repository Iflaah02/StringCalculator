import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {
	private StringCalculator calculator;

	@Before
	public void init() {
		calculator = new StringCalculator();
	}

	@Test
	public void testSumTwoNumbers() {
		// test1: let's test the sum of 2 numbers. (low-hanging fruit!)
		int result = calculator.sum(1, 2);
		assertEquals(3, result);
	}

	@Test
	public void testSumAnyQuantityOfNumbers() {
		// test1: let's test the sum of 4 numbers. (the next low-hanging fruit)
		int numbers[] = {1, 2, 3, 4};
		int result = calculator.sum(numbers);
		assertEquals(10, result);
	}

}
