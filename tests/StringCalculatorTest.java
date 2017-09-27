import static org.junit.Assert.*;

import org.junit.Test;


public class StringCalculatorTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetInput_Empty() {
		StringCalculator calc = new StringCalculator();
		
		calc.setInput("");
		
		assertEquals(calc.inputs[0], "");
	}
	
	@Test
	public void testSetInput_OneNumber() {
		StringCalculator calc = new StringCalculator();
		
		calc.setInput("1");
		
		assertEquals(calc.inputs[0], "1");
	}
	
	@Test
	public void testSetInput_TwoNumbers() {
		
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2");
		
		assertTrue(calc.inputs.length == 2);
		assertEquals(calc.inputs[0], "1");
		assertEquals(calc.inputs[1], "2");
	}
	
	@Test
	public void testSetInput_ThreeNumbers() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2,3");
		
		assertTrue(calc.inputs.length == 3);
		assertEquals(calc.inputs[0], "1");
		assertEquals(calc.inputs[1], "2");
		assertEquals(calc.inputs[2], "3");
	}
	
	@Test
	public void testCheckInput_Empty() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("");
		
		assertTrue(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_OneNumber() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1");
		
		assertTrue(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_TwoNumbers() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2");
		
		assertTrue(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_ThreeNumbers() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2,3");
		
		assertTrue(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_Character() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,a");
		
		assertFalse(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_NegativeNumber() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,-2");
		
		assertFalse(calc.checkInput());
	}
	
	@Test
	public void testCheckInput_NumberCharCombination() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2a");
		
		assertFalse(calc.checkInput());
	}
	

}
