import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {


	
	@Test
	public void ToInt() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "234";
		
		int sum = calc.parseInt(testString);
		
		assertEquals(234, sum);
	}
	
	@Test
	public void addArraytest() {
		StringCalculator calc = new StringCalculator();
		Slicer slicer = new Slicer();
		
		//calc.addArray(numbers);
		String numbersStr= "2,3,6";
		String[] numbers = slicer.slice(numbersStr);
		int sum = calc.addArray(numbers);
		
		assertEquals(11, sum);
	}
	@Test
	public void addNumbers() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "2,3,4";
		
		int sum = calc.add(testString);
		
		assertEquals(9, sum);
	}
	
	@Test (expected = StringCalculatorException.class)
	public void checkNegatives() throws StringCalculatorException {
		StringCalculator calc = new StringCalculator();

		String testString = "-2,3,2";
		
		calc.add(testString);
		
		assertEquals("-2,3,2", testString);
	}
	@Test
	public void addNumbers12() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "12";
		
		int sum = calc.add(testString);
		
		assertEquals(12, sum);
	}
	
	@Test
	public void addNumbers_1534() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "15,3,4";
		
		int sum = calc.add(testString);
		
		assertEquals(22, sum);
	}
	
	@Test
	public void addNumbers1space23() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "1\n2,3";
		
		int sum = calc.add(testString);
		
		assertEquals(6, sum);
	}
	
	@Test
	public void addNumbers1space232() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "1\n2,32";
		
		int sum = calc.add(testString);
		
		assertEquals(35, sum);
	}
	
	/*@Test
	public void addNumbers1space234() {
		StringCalculator calc = new StringCalculator();
		
		String testString = "1\n2,3,4";
		//should return "too long"
		int sum = calc.add(testString);
		
		assertEquals(35, sum);
	}*/

	

}
