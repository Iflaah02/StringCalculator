import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void testconvertToNumber_Not_a_number() {
		StringCalculator calc = new StringCalculator();
		int a = calc.convertToNumber("number");
		assertTrue(a == -1);
	}

	@Test
	public void testconvertToNumber_Is_a_number() {
		StringCalculator calc = new StringCalculator();
		int a = calc.convertToNumber("123");
		assertTrue(a == 123);
	}

	@Test
	public void testAdd_Nothing() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals("Expected value was 0", 0, calc.add(""));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testAdd_One_Number() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals("Expected value was 1", 1, calc.add("1"));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testAdd_Two_Numbers() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals("Expected value was 3", 3, calc.add("1,2"));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testAdd_Three_Numbers() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.add("1,2,3");
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testgetSumFromArray_Test_Full() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(6, calc.getSumFromArray(new String[] { "1", "2", "3" }));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testgetSumFromArray_Test_Empty() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.getSumFromArray(new String[] { "" });
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testgetSumFromArray_Test_Negative() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.getSumFromArray(new String[] { "1", "-2", "3" });
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddNumbersTogether_Test_Empty() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addNumbersTogether("", true, false);
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddNumbersTogether_Test_OnlyTwoNumbers_GiveTwo() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(3, (calc.addNumbersTogether("1,2", true, false)));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testAddNumbersTogether_Test_OnlyTwoNumbers_GiveThree() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addNumbersTogether("1,2,3", true, false);
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddNumbersTogether_Test_UnlimitedNumbers_GiveEmpty() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addNumbersTogether("", false, false);
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddNumbersTogether_Test_UnlimitedNumbers_GiveMany_OnlyCommas() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(21, (calc.addNumbersTogether("1,2,3,4,5,6", false, false)));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testAddNumbersTogether_Test_UnlimitedNumbers_GiveMany_OnlyCommas_WrongInput() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addNumbersTogether("1,2\n3,4\n5,6", false, false);
			fail();
		} catch (StringCalculatorException ex) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddNumbersTogether_Test_UnlimitedNumbers_GiveMany_AddNewLines() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(21, (calc.addNumbersTogether("1,2\n3,4\n5,6", false, true)));
		} catch (StringCalculatorException ex) {
			fail();
		}
	}

	@Test
	public void testParseNumberString_OK() {
		StringCalculator calc = new StringCalculator();
		String[] source = new String[] { "1", "ba", "cha2" };
		assertArrayEquals(source, calc.parseNumberString("1,ba,cha2", false));
	}

	@Test
	public void testParseNumberString_ParseOnlyCommas() {
		StringCalculator calc = new StringCalculator();
		String[] source = new String[] { "1", "ba", "\ncha2" };
		assertArrayEquals(source, calc.parseNumberString("1,ba,\ncha2", false));
	}

	@Test
	public void testParseNumberString_ParseNewLines() {
		StringCalculator calc = new StringCalculator();
		String[] source = new String[] { "1", "ba", "", "cha2" };
		assertArrayEquals(source, calc.parseNumberString("1,ba,\ncha2", true));
	}

	@Test
	public void testAddUnlimitedNumbers() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(21, calc.addUnlimitedNumbers("1,2,3,4,5,6"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddUnlimitedNumbers_Empty() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(0, calc.addUnlimitedNumbers(""));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddUnlimitedNumbers_WithNewLines() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addUnlimitedNumbers("1,2,3\n4,5,6");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	@Test
	public void testAddUnlimitedNumbers_WithNegativeNumbers() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addUnlimitedNumbers("1,2,3,-4,5,6");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddUnlimitedNumbers_WithNewLines_Empty() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(0, calc.addUnlimitedNumbersWithNewLinesSeparator(""));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddUnlimitedNumbers_WithNewLines_OK() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(21, calc.addUnlimitedNumbersWithNewLinesSeparator("1,2,3,4,5,6"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testAddUnlimitedNumbers_WithNewLines_MixedSeparators() {
		StringCalculator calc = new StringCalculator();
		try {
			assertEquals(21, calc.addUnlimitedNumbersWithNewLinesSeparator("1,2,3\n4,5,6"));
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void testAddUnlimitedNumbers_WithNewLines_MixedSeparators_NegativeNumber() {
		StringCalculator calc = new StringCalculator();
		try {
			calc.addUnlimitedNumbersWithNewLinesSeparator("1,-2,3\n4,5,6");
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
