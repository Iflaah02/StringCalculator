import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void add_emptyString_returnZero() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "";
		
		//Act
		Integer result = calculator.add(input);
		
		//Test
		Integer expected = 0;
		assertEquals(expected, result);
	}
	
	@Test
	public void add_oneElementString_returnValue() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12";
		
		//Act
		Integer result = calculator.add(input);
		
		//Test
		Integer expected = 12;
		assertEquals(expected, result);
	}
	
	@Test
	public void add_twoElementString_returnSum() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12,13";
		
		//Act
		Integer result = calculator.add(input);
		
		//Test
		Integer expected = 25;
		assertEquals(expected, result);
	}

	@Test
	public void add_moreThanThreeElementString_returnSum() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12,13,25,42";
		
		//Act
		Integer result = calculator.add(input);
		
		//Test
		Integer expected = 92;
		assertEquals(expected, result);
	}
	
	@Test(expected = StringCalculatorException.class) 
	public void add_oneNegativeElementString_throwException() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "-12";
		
		//Act
		Integer result = calculator.add(input);
	}
	
	@Test(expected = StringCalculatorException.class) 
	public void add_multipleNegativeElementString_throwException() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12,-13";
		
		//Act
		Integer result = calculator.add(input);
	}
	
	@Test
	public void add_newLineSeparator_returnSum() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12,13" + System.getProperty("line.separator") + "25,42";
		
		//Act
		Integer result = calculator.add(input);
		
		//Test
		Integer expected = 92;
		assertEquals(expected, result);
	}
	
	@Test(expected = StringCalculatorException.class) 
	public void add_newLineSeparator_throwsException() throws StringCalculatorException {
		//Init
		StringCalculator calculator = new StringCalculator();
		String input = "12," + System.getProperty("line.separator");
		
		//Act
		Integer result = calculator.add(input);
	}
}
