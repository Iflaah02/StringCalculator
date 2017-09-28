import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {


	/*@Test
	public void testStringCalculator_InputCorrect() {
		
		StringCalculator calc = new StringCalculator();
		
		String testr = calc.readInput();
		
		assertEquals("2, 2", testr);
	}*/
	
	@Test (expected = StringCalculatorException.class)
	public void testStringCalculator_NumberTest() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		String testr = "2ab";
		
		calc.numberCount(testr);
	}
	
	@Test 
	public void testStringCalculator_NumberCount() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();
		
		String testr = "22,2\n 22";
		
		int i = calc.numberCount(testr);
		
		assertEquals(i, 3);
	}
	
	@Test
	public void testStringCalculator_ArrayCorrect() {
		
		StringCalculator calc = new StringCalculator();
		
		int[] arr1 = calc.getIntegers("26, 19 \n 2", 3);
		
		int[] arr2 = {26, 19, 2};
		

		assertArrayEquals(arr1, arr2);
	}
	
	@Test
	public void testStringCalculator_AddCorrect() {
		
		StringCalculator calc = new StringCalculator();
		
		int testint = calc.add("3, 2 \n22");
		
		assertEquals(27, testint);
	}
}
