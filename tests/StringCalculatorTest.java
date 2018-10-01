import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void task1_2_number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(3, sc.add("1,2"));
	}
	@Test
	public void task1_0() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add(""));
	}
	@Test
	public void task1_1_number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(1, sc.add("1"));
	}
	@Test
	public void add2_task1_multiple_number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(30, sc.add2("1,8,3,9,4,3,2"));
	}
	@Test
	public void add2_task1_multiple_number_0() {
		StringCalculator sc = new StringCalculator();
		assertEquals(0, sc.add2(""));
	}
	@Test
	public void add3_task1_multiple_number() {
		StringCalculator sc = new StringCalculator();
		assertEquals(31, sc.add3("1,8,4/n9,4,3,2"));
	}
	@Test
	public void add3_task1_multiple_number_virgn() {
		StringCalculator sc = new StringCalculator();
		assertEquals(13, sc.add3("1,8,4,/n"));
	}
}
