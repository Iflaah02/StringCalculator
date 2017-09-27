import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	public void testSetInput_MultiDigit() {
		StringCalculator calc = new StringCalculator();
		
		calc.setInput("123");
		
		assertEquals(calc.inputs[0], "123");
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
	public void testCheckInput_MultiDigit() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("123,234");
		
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
	
	@Test
	public void testParseNumbers_Empty() {
		
		StringCalculator calc = new StringCalculator();
		calc.setInput("");
		
		calc.parseNumbers();
		
		assertEquals(Arrays.asList(0), calc.numbers);
		
	}
	
	@Test
	public void testParseNumbers_OneNumber() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1");
		
		calc.parseNumbers();
		
		assertEquals(Arrays.asList(1), calc.numbers);
	}
	
	@Test
	public void testParseNumbers_TwoNumbers() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2");
		
		calc.parseNumbers();
		
		assertEquals(Arrays.asList(1,2), calc.numbers);
	}
	
	@Test
	public void testParseNumbers_ThreeNumbers() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("1,2,3");
		
		calc.parseNumbers();
		
		assertEquals(Arrays.asList(1,2,3), calc.numbers);
	}
	
	@Test
	public void testParseNumbers_MultiDigit() {
		StringCalculator calc = new StringCalculator();
		calc.setInput("123,234,345");
		
		calc.parseNumbers();
		
		assertEquals(Arrays.asList(123,234,345), calc.numbers);
	}
	

}
