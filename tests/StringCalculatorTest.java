import static org.junit.Assert.*;

import org.junit.Test;
public class StringCalculatorTest {

	@Test //USER STORY 1, REQUIREMENT 1
	public void test_twoNumbers() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = 0;
		result = calc.add("1,2");
		
		assertEquals("3", 3, result);
	}
	
	@Test //USER STORY 2, REQUIREMENT 1
	public void test_oneNumber() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1");
		
		assertEquals("0", 0, result);
	}
	
	@Test //USER STORY 3, REQUIREMENT 2
	public void test_multiple() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2,3");
		
		assertEquals("6", 6, result);
	}
	
	@Test //USER STORY 4, REQUIREMENT 3
	public void test_twoNumbers_with_linebreak() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1\n2");
		
		assertEquals("3", 3, result);
	}
	
	@Test //USER STORY 5, REQUIREMENT 3
	public void test_multiple_with_linebreak() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = calc.add("1,2\n3");
		
		assertEquals("6", 6, result);
	}
	

	@Test (expected = StringCalculatorException.class) //USER STORY 6, REQUIREMENT 4
	public void test_twoNumbers_negative() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		int result = 0;
		result = calc.add("1,-2");
		
	}
}
