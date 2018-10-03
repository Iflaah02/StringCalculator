import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	
	@Test
	public void test_sum_6() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("1,2,3"), 6);
	}
	
	@Test
	public void test_one_value() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2"), 2);
	}
	
	@Test
	public void test_empty() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add(""), 0);
	}
	
	@Test
	public void test_four_commas() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2,4,6,8"), 12);
	}
	
	@Test
	public void test_three_commas() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2,4,1"), 7);
	}
	
	@Test
	public void test_two_commas() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2,6"), 8);
	}
	
	@Test
	public void test_four_newlines() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2\n4\n6\n8"), 12);
	}
	
	@Test
	public void test_three_newlines() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2\n4\n1"), 7);
	}
	
	@Test
	public void test_two_newlines() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2\n6"), 8);
	}
	
	@Test
	public void test_one_comma_two_newlines() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2,3\n6\n5"), 11);
	}
	
	@Test
	public void test_two_comma_one_newlines() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2\n3,6,5"), 11);
	}
	
	@Test
	public void test_one_comma_one_newline() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.add("2\n3,6"), 11);
	}
	
	@Test
	public void test_false_value() {
		ValuesHandler vh = new ValuesHandler();
		assertEquals(vh.checkStringValue("a"), false);
	}
	
	@Test
	public void test_true_value() {
		ValuesHandler vh = new ValuesHandler();
		assertEquals(vh.checkStringValue("4"), true);
	}
	
	@Test
	public void test_check_empty_value_true() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.checkEmptyString("4"), "1");
	}
	
	@Test
	public void test_check_empty_value_false() {
		StringCalculator sc = new StringCalculator();
		assertEquals(sc.checkEmptyString(""), "0");
	}

}
