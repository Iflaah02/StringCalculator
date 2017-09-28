import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StringCalculatorTest {
	
	@Test
	public void testTrimInput() {
		
		StringCalculator calculator = new StringCalculator();
		
		String input = "text to \ntrim     ";
		String output = calculator.trimInput(input);
		
		assertTrue(output instanceof String);
		assertEquals("Got " + output, "text to trim", output);
		
	}
	
	@Test
	public void testSplitInput() {
		
		StringCalculator calculator = new StringCalculator();
		
		String input = "1,2,3";
		String[] expectedOutput = {"1","2","3"};
		String[] output = calculator.splitInput(input);
		
		assertTrue(output instanceof String[]);
		assertEquals(expectedOutput, output);
		
	}
	
	@Test
	public void testConvertToIntegerArray() throws StringCalculatorException {
		
		StringCalculator calculator = new StringCalculator();
		
		String[] input = {"1","2","3"};
		ArrayList expectedOutput = new ArrayList();
		expectedOutput.add(Integer.parseInt("1"));
		expectedOutput.add(Integer.parseInt("2"));
		expectedOutput.add(Integer.parseInt("3"));
		
		ArrayList output = calculator.convertToIntegerArray(input);
		
		assertTrue(output instanceof ArrayList);
		assertEquals(expectedOutput, output);
		
	}
	
	@Test
	public void testNumberArrayListToList() throws StringCalculatorException {
		
		StringCalculator calculator = new StringCalculator();
		
		ArrayList input = new ArrayList();
		input.add(Integer.parseInt("1"));
		input.add(Integer.parseInt("2"));
		input.add(Integer.parseInt("3"));
		
		int[] expectedOutput = new int[3];
		expectedOutput[0] = (int) 1;
		expectedOutput[1] = (int) 2;
		expectedOutput[2] = (int) 3;
		
		int[] output = calculator.numberArrayListToList(input);
		
		assertTrue(output instanceof int[]);
		assertEquals(expectedOutput, output);
		
	}

	@Test
	public void testSumValidInput() throws StringCalculatorException {
		
		StringCalculator calculator = new StringCalculator();
		
		int sum = calculator.add("1,2,3");
		assertEquals(6, sum);
		
	}

}
