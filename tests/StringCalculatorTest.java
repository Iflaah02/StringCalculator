import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void nullTest() {
		assertEquals(0, StringCalculator.add(""));

	}

	@Test
	public void returnSameThing() {
		assertEquals(1, StringCalculator.add("1"));

	}
	@Test
	public void sumTwoNumbers() {
		assertEquals(2, StringCalculator.add("1,1"));

	}
	@Test
	public void sumTwoNumbers2() {
		assertEquals(56, StringCalculator.add("55,1"));

	}
	@Test
	public void severalNumbers() {
		assertEquals(0, StringCalculator.add(“/n”));

	}
	
}
