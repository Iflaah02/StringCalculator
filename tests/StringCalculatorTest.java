import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void test_add_sum_123() {
		StringCalculator sc = new StringCalculator();
		int sum = 0;
		try {
			sum = sc.add("1,2,3,3");
		} catch(StringCalculatorException e) {
			fail("Exception caught");
		}
		assertEquals("Sum wasn't 9", sum, 9);
	}
	
	@Test
	public void test_add_sum_empty() {
		StringCalculator sc = new StringCalculator();
		int sum = 0;
		try {
			sum = sc.add("");
		} catch(StringCalculatorException e) {
			fail("Exception caught");
		}
		assertEquals("Sum wasn't 0", sum, 0);
	}
	
	@Test
	public void test_str2int_positive() {
		StringCalculator sc = new StringCalculator();
		int num = 0;
		try {
			num = sc.str2int("10");
		} catch(StringCalculatorException e) {
			fail("Exception caught");
		}
		assertEquals("Sum wasn't 0", num, 10);
	}
	
	@Test
	public void test_str2int_negative() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.str2int("-10");
			fail("No exception was caught");
		} catch(StringCalculatorException e) {}
	}
	
	@Test
	public void test_str2int_invalid() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.str2int("kymmenen");
			fail("No exception was caught");
		} catch(StringCalculatorException e) {}
	}
	
	@Test
	public void test_get_intAr_valid() {
		StringCalculator sc = new StringCalculator();
		Integer[] intAr = {0, 0, 0};
		try {
			intAr = sc.get_intAr("0,1\n2");
		} catch(StringCalculatorException e) {
			fail("Exception caught");
		}
		assertEquals("intAr[0] wasn't 0", (int)intAr[0], 0);
		assertEquals("intAr[1] wasn't 1", (int)intAr[1], 1);
		assertEquals("intAr[2] wasn't 2", (int)intAr[2], 2);
	}
	
	@Test
	public void test_get_intAr_invalid() {
		StringCalculator sc = new StringCalculator();
		try {
			sc.str2int("5,");
			fail("No exception was caught");
		} catch(StringCalculatorException e) {}
	}
}
