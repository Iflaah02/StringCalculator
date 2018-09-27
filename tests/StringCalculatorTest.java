import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void test_checkNums_1() {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList = calc.checkNums("1,2");
		assertTrue(arrList.get(0).equals(1));
		assertTrue(arrList.get(1).equals(2));
	}
	
	@Test
	public void test_checkNums_2() {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList = calc.checkNums("1,2,3");
		assertTrue(arrList.isEmpty());
	}
	
	@Test
	public void test_checkNums_3() {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList = calc.checkNums("1sdfdfghfgdjtygkjtyhgb9io.,,.,.,,vggr,2,3");
		assertTrue(arrList.isEmpty());
	}
	
	@Test
	public void test_checkNums_4() {
		StringCalculator calc = new StringCalculator();
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList = calc.checkNums("1\n2");
		assertTrue(arrList.get(0).equals(1));
		assertTrue(arrList.get(1).equals(2));
	}
	
	@Test
	public void test_handleNewLines_1() {
		StringCalculator calc = new StringCalculator();
		String str = calc.handleNewLines("1\n2");
		assertEquals(str, "1,2");
	}

	@Test
	public void test_handleNewLines_2() {
		StringCalculator calc = new StringCalculator();
		String str = calc.handleNewLines("1,2");
		assertEquals(str, "1,2");
	}

	@Test
	public void test_handleNewLines_3() {
		StringCalculator calc = new StringCalculator();
		String str = calc.handleNewLines("1\n2,3");
		assertEquals(str, "1,2,3");
	}

	@Test
	public void test_add_1() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1\n2");
		assertEquals(result, 3);
	}
	
	@Test
	public void test_add_2() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2");
		assertEquals(result, 3);
	}
	
	@Test
	public void test_add_3() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1");
		assertEquals(result, 1);
	}
	
	@Test
	public void test_add_4() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2,3");
		assertEquals(result, 0);
	}
	
	@Test
	public void test_add_5() {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1erwgergerg,erg,o,erg");
		assertEquals(result, 0);
	}


}
